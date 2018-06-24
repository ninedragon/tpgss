var topoError =[ {
	 "type": "branchBox",
	    "key": "63075eef-bdab-49bd-b421-187b70102d5e",
	    "fault_type": "0",  //0表示分支箱汇总的数据多于出线柜，1表示少于出线柜
	    "rel": [
	        {
	            "type": "meterBox",
	            "key": "1952cf11-aa19-4423-ab44-15a903a36b6c",
	             "fault_point": "1"
	        },
	        {
	            "type": "meterBox",
	            "key": "2ee4fddb-ef9f-4874-baf7-0697af97a63b",
	             "fault_point": "1"//表示该节点的数据过大，导致分支箱汇总的数据多于出线柜
	        }
	    ]
	
},
{
	 "type": "branchBox",
	    "key": "372d7733-da1a-4a6e-b993-70560a92b1d4",
	    "fault_type": "1",  //0表示分支箱汇总的数据多于出线柜，1表示少于出线柜
	    "rel": [
	        {
	            "type": "meterBox",
	            "key": "1305ca7c-463d-4aea-ae0c-7dc712470ab4",
	             "fault_point": "1"
	        },
	        {
	            "type": "meterBox",
	            "key": "2fe9e586-1373-4aaa-a900-7aeb9702c47c",
	             "fault_point": "1"//表示该节点的数据过大，导致分支箱汇总的数据多于出线柜
	        }
	    ]
	
}
];