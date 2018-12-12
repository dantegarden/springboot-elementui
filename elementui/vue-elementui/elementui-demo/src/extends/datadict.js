import Vue from 'vue'
import api from '@/api'

const dataDict = async dictTypes => {
  let dictionary = {}

  let res = await api.code(dictTypes);
  if(res.status){
    let data = res.data
    Object.keys(data).forEach(codeType => {
      let oneDict = []
      Object.keys(data[codeType]).forEach(codeValue => {
        let codeName = data[codeType][codeValue]
        oneDict.push({"label": codeName, "value": codeValue})
      })
      dictionary[codeType] = oneDict
    })
  }
  return dictionary;
}

const translate = function(codeValue, codeType){
  let data = this.dataDict[codeType];
  let entry = data.find(entry=> entry.value == codeValue)
  return entry? entry.label : codeValue
}

Vue.prototype.$dataDict = dataDict
Vue.prototype.$dataTrans = translate
