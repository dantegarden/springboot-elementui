<template>
        <div class="cbox1">
            <div ref="cbox" class="checkBox1" @mouseleave="cboxMouseLeave">
                <img src="/static/images/search_icon.png?imageView2/1/w/80/h/80" width="16" class="user-avatar"/>
                <input type="text" v-if="fieldFilter.length==0" :placeholder="placeholder"  @click="toggleSlide"/>
                <div class="add1"  v-else @click="toggleSlide">
                        <span v-for="(item,index) in fieldFilter">
                            {{item.label}}
                            <img @click.stop.prevent="deleteFieldFilter(index)" src="/static/images/delete_item_icon.png?imageView2/1/w/80/h/80" width="12" class="user-avatar"/>
                        </span>
                </div>
                <div class="checkBox2">
                    <p class="fontW title">添加自定义筛选</p>
                    <div v-for="(item,iindex) in currentFieldFilter.query">
                        <span class="huo" v-if="currentFieldFilter.query.length>1 && iindex>0">或</span>
                        <p>
                            <select type="text" placeholder="请选择" v-model="item[0]">
                                <option value='' disabled selected style='display:none;'>请选择</option>
                                <option v-for="kv in fieldSelections" :value="kv.field">{{kv.label}}</option>
                            </select>
                            <img @click="clearFieldFilter(iindex)" src="/static/images/delete_icon.png?imageView2/1/w/80/h/80" width="16" class="user-avatar"/>
                        </p>
                        <p>
                            <select type="text" placeholder="请选择" v-model="item[1]">
                                <option v-for="kv in relations" :value="kv.value">{{kv.label}}</option>
                            </select>
                        </p>
                        <p><input type="text" placeholder="请选择" v-model="item[2]"/></p>
                    </div>

                    <div>
                        <p>
                            <button class="blueBtn" @click="useFieldFilter" >应用</button>
                            <button class="whiteBtn" @click="addFieldFilter">
                                <img src="/static/images/add_icon.png?imageView2/1/w/80/h/80" width="16" class="user-avatar"/>
                                <span>添加条件</span>
                            </button>
                        </p>
                    </div>
                </div>
            </div>
        </div>
</template>

<script type="text/ecmascript-6">
    export default {
        name: "FieldFilter",
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
                    return '请选择筛选条件'
                }
            }
        },
        data() {
            return {
                relations: [
                    {value: 'like', label:'包含'},
                    {value: 'not like', label:'不包含'},
                    {value: '=', label:'等于'},
                    {value: '!=', label:'不等于'},
                    {value: 'startwith', label:'找开头是'},
                    {value: 'endwith', label:'找结尾是'},
                ],
                currentFieldFilter: {
                    label: '',
                    relation: 'and',
                    query: [["", "like", ""]]
                },
                lock: false,
                checkboxTop: '33px'
            }
        },
        methods: {
            syncModel(){
                this.$emit('filter', this.fieldFilter)
            },
            useFieldFilter(){
                let currentFieldFilter = this.currentFieldFilter

                this.lock = false
                this.$emit('onUseFieldFilter', {$vm: this, current: currentFieldFilter});
                if(!this.lock){
                    let labels = [];
                    let check_flag = currentFieldFilter.query.every(item => {
                        if(item[0]==="" || item[1]==="" || item[2]===""){
                            alert('筛选条件不能为空')
                            return false
                        }else{
                            let field_kv = this.fieldSelections.find(kv => kv.field === item[0])
                            let relation_kv = this.relations.find(kv => kv.value=== item[1])
                            labels.push(field_kv.label+ " " +relation_kv.label+ " " + item[2]+"; " );
                            return true
                        }
                    })
                    if(check_flag){
                        currentFieldFilter.label = labels.join(currentFieldFilter.relation === "or"?'或':'且')
                        this.fieldFilter.push(currentFieldFilter)
                        this.currentFieldFilter = {
                            label: '',
                            relation: 'and',
                            query: [["", "like", ""]]
                        }
                        this.syncModel();
                    }
                }

                this.$emit('afterUseFilter');
            },
            addFieldFilter(){
                this.currentFieldFilter.query.push(["", "like", ""])
                this.currentFieldFilter.relation = "or";
            },
            deleteFieldFilter(index){
                this.fieldFilter.splice(index, 1)
                this.syncModel()
                this.$emit('onDeleteFilter', index);
            },
            clearFieldFilter(index){
                if(this.currentFieldFilter.query.length==1){return}
                this.currentFieldFilter.query.splice(index,1)
                if(this.currentFieldFilter.query.length==1){
                    this.currentFieldFilter.relation = "and";
                }
            },
            toggleSlide(e){
                let $div = $(e.target).siblings('.checkBox2')
                $div.stop(false,true).slideDown('slow')
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
            this.checkboxTop = $(this.$refs.cbox).find(".checkBox2").css("top")

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