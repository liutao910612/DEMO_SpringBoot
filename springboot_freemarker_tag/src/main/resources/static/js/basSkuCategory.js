$(function(){


    //组合树
    $('#cc').combotree({
        data:json,
        // required: true,
        valueField:'id',
        textField:'name'
    });

})

var json=[{
    "id":1,
    "name":"C",
    "size":"",
    "date":"02/19/2010",
    "children":[{
        "id":2,
        "name":"Program Files",
        "size":"120 MB",
        "date":"03/20/2010",
        "children":[{
            "id":21,
            "name":"Java",
            "size":"",
            "date":"01/13/2010",
            "state":"closed",
            "children":[{
                "id":211,
                "name":"java.exe",
                "size":"142 KB",
                "date":"01/13/2010"
            },{
                "id":212,
                "name":"jawt.dll",
                "size":"5 KB",
                "date":"01/13/2010"
            }]
        },{
            "id":22,
            "name":"MySQL",
            "size":"",
            "date":"01/13/2010",
            "state":"closed",
            "children":[{
                "id":221,
                "name":"my.ini",
                "size":"10 KB",
                "date":"02/26/2009"
            },{
                "id":222,
                "name":"my-huge.ini",
                "size":"5 KB",
                "date":"02/26/2009"
            },{
                "id":223,
                "name":"my-large.ini",
                "size":"5 KB",
                "date":"02/26/2009"
            }]
        }]
    },{
        "id":3,
        "name":"eclipse",
        "size":"",
        "date":"01/20/2010",
        "children":[{
            "id":31,
            "name":"eclipse.exe",
            "size":"56 KB",
            "date":"05/19/2009"
        },{
            "id":32,
            "name":"eclipse.ini",
            "size":"1 KB",
            "date":"04/20/2010"
        },{
            "id":33,
            "name":"notice.html",
            "size":"7 KB",
            "date":"03/17/2005"
        }]
    }]
}]

var json2={"total":7,"rows":[
    {"id":1,"name":"所有部门","_parentId":0},
    {"id":2,"name":"广东省","_parentId":1},
    {"id":3,"name":"广州市","_parentId":1},
    {"id":4,"name":"深圳","_parentId":1},
    {"id":5,"name":"白云区","_parentId":2},
    {"id":6,"name":"天河区","_parentId":2}
]};

var json2={
    "total":7,"rows":[
        {"id":1,"name":"所有部门","_parentId":0},
        {"id":2,"name":"广东省","_parentId":1},
        {"id":3,"name":"广州市","_parentId":1},
        {"id":4,"name":"深圳","_parentId":1},
        {"id":5,"name":"白云区","_parentId":2},
        {"id":6,"name":"天河区","_parentId":2}
    ]};
var json3=[
    {"id":1,"text":"所有部门","_parentId":null},
    {"id":2,"text":"广东省","_parentId":1},
    {"id":3,"text":"广州市","_parentId":1},
    {"id":4,"text":"深圳","_parentId":1},
    {"id":5,"text":"白云区","_parentId":2},
    {"id":6,"text":"天河区","_parentId":2}
];
var json=[{
    "id":1,
    "text":"C",
    "size":"",
    "date":"02/19/2010",
    'state':'open',
    "children":[{
        "id":2,
        "text":"Program Files",
        "size":"120 MB",
        "date":"03/20/2010",
        'state':'open',
        "children":
            [{
                "id":21,
                "text":"Java",
                "size":"",
                "date":"01/13/2010",
                'state':'open',
                "children":[{
                    "id":211,
                    "text":"java.exe",
                    "size":"142 KB",
                    "date":"01/13/2010"
                },{
                    "id":212,
                    "text":"jawt.dll",
                    "size":"5 KB",
                    "date":"01/13/2010"
                }]
            },{
                "id":22,
                "text":"MySQL",
                "size":"",
                "date":"01/13/2010",
                'state':'open',
                "children":[{
                    "id":221,
                    "text":"my.ini",
                    "size":"10 KB",
                    "date":"02/26/2009"
                },{
                    "id":222,
                    "text":"my-huge.ini",
                    "size":"5 KB",
                    "date":"02/26/2009"
                },{
                    "id":223,
                    "text":"my-large.ini",
                    "size":"5 KB",
                    "date":"02/26/2009"
                }]
            }]
    }]
}]

