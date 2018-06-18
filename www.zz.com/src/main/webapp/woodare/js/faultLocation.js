var dataTemp = 
[{   "id":"1",//一个故障对象的id
    "type": "substain",
    "key": "3f95ae7a-f99c-45f4-b82f-7f0b2093f186",
    "faultType":"0",//0short表示短路，1ableakage异常漏电，2pahseLoss缺相，3powerFailure停电
    "occur_time":"2014-05-24 09:46:22",//故障发生时间
    "is_cancelled":"1",//是否被取消，1表示是，前端需要用这个做查询筛选 
    "is_repaired":"0",//是否被修复，1表示是，前端需要用这个做查询筛选
    "repair_time":"2014-05-25 09:46:22"//故障修复时间

},
{   "id":"2",
    "type": "outgoingCabinet",
    "key": "8b1cec1b-5d75-4673-b5b5-e7d26bea26a6",
    "faultType":"1",
    "occur_time":"2013-03-22 09:46:22",//故障发生时间
    "is_cancelled":"1",//是否被取消，1表示是
    "is_repaired":"0",//是否被修复，1表示是
    "repair_time":"2013-03-24 09:46:22"//故障修复时间
},
{   "id":"3",
    "type": "branchBox",
    "key": "372d7733-da1a-4a6e-b993-70560a92b1d4",
    "faultType":"2",
     "occur_time":"2018-05-25 09:46:22",//故障发生时间
    "is_cancelled":"1",//是否被取消，1表示是
    "is_repaired":"0",//是否被修复，1表示是
    "repair_time":"2018-05-25 09:46:22"//故障修复时间
},
{   "id":"4",
    "type": "meterBox",
    "key": "1305ca7c-463d-4aea-ae0c-7dc712470ab4",
    "faultType":"3",
     "occur_time":"2017-05-25 09:46:22",//故障发生时间
    "is_cancelled":"1",//是否被取消，1表示是
    "is_repaired":"0",//是否被修复，1表示是
    "repair_time":"2017-06-18 22:33:48"//故障修复时间

},
{   "id":"5",
    "type": "meter",
    "key": "bdb2ccda-d56d-4bae-a44b-147094e3c68f",
    "faultType":"4" ,
     "occur_time":"2018-05-25 09:46:22",//故障发生时间
    "is_cancelled":"1",//是否被取消，1表示是
    "is_repaired":"0",//是否被修复，1表示是
    "repair_time":"2018-05-25 09:50:22"//故障修复时间       
}];