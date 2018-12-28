<template>
    <div class="cbox1">
        <div ref="cbox" class="checkBox1" >
            <img src="/static/images/search_icon.png?imageView2/1/w/80/h/80" width="16" class="user-avatar"/>
            <input type="text" v-if="fieldFilter.length==0" :placeholder="placeholder" @click="toggleSlide"/>
            <div class="add1" v-else @click="toggleSlide">
                <span v-for="(item,index) in fieldFilter">
                    {{item}}
                    <img @click.stop.prevent="deleteKeys(index)" src="/static/images/delete_item_icon.png?imageView2/1/w/80/h/80" width="12" class="user-avatar"/>
                </span>
            </div>
            <div class="checkBox2 click2">
                <p class="fontW title">请选择</p>
                <div>
                    <ul>
                        <li v-for="kv in fieldSelections" :class="{'on':fieldFilter.includes(kv.label)}"  :role="kv.field" @click="selectKeys(kv)">{{kv.label}}</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</template>

<script type="text/ecmascript-6">
    export default {
        name: "TableHeaderFilter",
        model: {
            prop: 'fieldFilter',
            event: 'filter'
        },
        props: {
            fieldFilter: { //选项
                type: Array,
                default: function () {
                    return [];
                }
            },
            fieldSelections: { //选项
                type: Array,
                default: function () {
                    return [];
                }
            },
            placeholder: {
                type: String,
                default: function(){
                    return '请选择表头项'
                }
            }
        },
        data() {
            return {
                lock: false,
                checkboxTop: '33px'
            }
        },
        methods: {
            syncModel(){
                this.$emit('filter', this.fieldFilter)
            },
            selectKeys(kv){
                this.lock = false
                this.$emit('onSelectKey', {$vm: this, current:kv});
                if(!this.lock){
                    if(this.fieldFilter.includes(kv.label)) return
                    this.fieldFilter.push(kv.label)
                    this.syncModel()
                }
                this.$emit('afterSelectKey', kv);
            },
            deleteKeys(index){
                this.fieldFilter.splice(index, 1)
                this.syncModel()
                this.$emit('onDeleteKey', index);
            },
            toggleSlide(e){
                $(e.target).siblings('.checkBox2').stop(false,true).slideDown('slow')
            },
            cboxMouseLeave(e){
                console.log(e.target)
                if(!$(e.target).closest('.checkBox1')[0]){
                    $(this.$refs.cbox).find('.checkBox2').slideUp('slow')
                }
            }
        },
        watch: {
            fieldFilter: {
                handler(newValue, oldValue) {
                    this.$nextTick(()=>{
                        if(this.fieldFilter.length>1){
                            $(this.$refs.cbox).find(".checkBox2").css("top", $(this.$refs.cbox).find('.add1').outerHeight()-3 +"px")
                        }else if(this.fieldFilter.length==1){
                            $(this.$refs.cbox).find(".checkBox2").css("top", this.checkboxTop)
                        }
                    })
                },
                deep: true
            }
        },
        mounted(){
            let body = document.querySelector('body')
            body.addEventListener('click',this.cboxMouseLeave,false)
        },
        beforeDestroy() {
            let body = document.querySelector('body')
            body.removeEventListener('click', this.cboxMouseLeave);
        }
    }
</script>

<style lang="less" scoped>
    .fontW {
        font-weight: bold;
    }

    ul,
    li {
        list-style: none;
    }

    .checkBox1,
    .checkBox2 {
        border: solid 1px rgb(149, 149, 149);
    }

    .checkBox1 {
        height: 35px;
        position: relative;
    }

    .checkBox1 > img {
        position: absolute;
        top: 50%;
        margin-top: -8px;
        left: 16px;
        /*z-index: 3;*/
    }

    .checkBox1 input {
        width: 99%;
        height: 100%;
        border: none;
        padding-left: 36px;
        font-size: 12px;
        margin-left: 1px;
        outline: none;
    }
    .checkBox2 input{
        padding-left: 10px;
    }
    .checkBox2 {
        display: none;
        position: absolute;
        left: -1px;
        right: -1px;
        top: 33px;
        z-index: 2;
        background-color: #fff;
    }

    .checkBox2 p {
        padding-left: 36px;
        margin-bottom: 4px;
        margin-top: 0;
    }

    .checkBox2 > p.title {
        margin-top: 19px;
    }

    .checkBox2 input, .checkBox2 select{
        width: 80%;
        height: 32px;
        border: solid 1px rgb(210, 210, 210);
        margin-right: 6px;
    }

    .checkBox2 > div {
        margin-bottom: 19px;
        position: relative;
    }

    .checkBox2 > div .huo {
        position: absolute;
        top: 8px;
        left: 16px;
    }

    .checkBox2 input::-webkit-input-placeholder {
        /* WebKit browsers */
        color: rgb(199, 199, 199);
    }

    .checkBox2 input :-moz-placeholder {
        /* Mozilla Firefox 4 to 18 */
        color: rgb(199, 199, 199);
    }

    .checkBox2 input::-moz-placeholder {
        /* Mozilla Firefox 19+ */
        color: rgb(199, 199, 199);
    }

    .checkBox2 input :-ms-input-placeholder {
        /* Internet Explorer 10+ */
        color: rgb(199, 199, 199);
    }
    button{cursor: pointer;}
    .blueBtn {
        width: 80px;
        height: 35px;
        color: #fff;
        font-size: 14px;
        background-color: rgb(38, 100, 195);
        border: none;
        margin-right: 5px;
        margin-top: 2px;
    }

    .whiteBtn {
        width: 110px;
        height: 35px;
        font-size: 14px;
        background-color: #fff;
        border-radius: 4px;
        color: rgb(51, 51, 51);
        border: solid 1px rgb(210, 210, 210);
    }

    .add1 {
        position: absolute;
        top: -1px;
        left: -1px;
        right: -1px;
        background-color: #fff;
        padding-top: 6px;
        padding-left: 4px;
        border: solid 1px rgb(149, 149, 149);
        min-height: 35px;
        /*display: none;*/
        z-index: 2;
    }

    .add1 span {
        border: 1px solid #ccc;
        background-color: #eee;
        margin-right: 6px;
        margin-bottom: 6px;
        display: block;
        float: left;
        font-size: 12px;
        padding: 1px 2px;
    }

    img,
    span,
    button {
        vertical-align: middle;
    }

    .checkBox2 > div ul {
        margin-left: 36px;
    }

    .checkBox2 > div ul:after {
        display: block;
        clear: both;
        content: "";
        visibility: hidden;
        height: 0;
    }

    .checkBox2 > div ul li {
        margin-top: 20px;
        float: left;
        width: 33%;
        padding-left: 20px;
        cursor: pointer;
    }

    .checkBox2 > div ul li.on {
        background: url("/static/images/checked_icon.png?imageView2/1/w/80/h/80") no-repeat;
        background-size: 16px;
        background-position: left;
    }
</style>