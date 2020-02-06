function query(nid,mark) {
    $("#medicine-list").css({"display":"none"});
    $("#medicine-xq").css({"display":"table"});
    $.ajax({
        url: "/medicinal/NonPre/getById",
        data: {"nid": nid,"mark":mark},
        type: "GET",
        dataType: "json",
        success: function (data) {
            console.log(data)
            $("#medicinal-name").html(data.data.nname);
            $("#fromDrug").html(data.data.fromdrug);
            $("#medicinal-specs").html(data.data.specs);
            $("#indication").html(data.data.indication);
            $("#usetaboo").html(data.data.usetaboo);
            $("#dosageandadministration").html(data.data.dosageandadministration);
            $("#basis").html(data.data.basis);
            $("#batch").html(data.data.batch);
            $("#mark").html(data.data.mark);
            $("#remark").html(data.data.remark);

        },
        error: function (err) {
            alert("出错了")
        }
    });
}

function fan() {
    window.location.reload()
    //window.history.back(-1);
}

function gopage(pagename) {
    if(pagename=='jia'){
        location.href="medicine-jia.html"
    }else if(pagename=='yi'){
        location.href="medicine-yi.html"
    }
}
function getNonPre(ndcid,currentPage,nName){
    $.ajax({
        url: "/medicinal/NonPre/getNonPre",
        data: {"ndcid": ndcid,"currentPage":currentPage,"nName":nName},
        type: "GET",
        dataType: "json",
        success: function (data) {
            console.log(data)
            //$("#medicinal-tbody").empty();
            var nohtml = '<tr>';
            $(data.data.list).each(function (index, item) {
                //var kind = item.ndcid == 0 ? '甲类':'乙类'
                if(index % 4 == 0){
                    nohtml += '</tr><tr>';
                }
                nohtml += '<td style="padding-left: 40px" onclick="query('+item.nid+')">' +item.nname
                '</td>'
            });
            $("#medicinal-tbody").html(nohtml);
            //page1(data.data.total)
        },
        error: function (err) {
            alert("出错了")
        }
    });
}

function page1(ndcid,nName) {
    $.ajax({
        url: "/medicinal/NonPre/getNonPre",
        data: {"ndcid": ndcid},
        type: "GET",
        dataType: "json",
        success: function (data) {
            var box = new CustomPagination('#page', {
                total: data.data.pages,//总页数
                changePage: function (pageNum) {//切换页码成功回调
                    console.log('当前页码：'+pageNum)
                    getNonPre(ndcid,pageNum,nName);
                }
            });
        },
        error: function (err) {
            alert("出错了")
        }
    });

}

function search(ndcid) {
    var myselect=$("#check-search option:selected").val();
    console.log(myselect)
    var searchtext=$("#search-text").val();
    console.log(searchtext)
    if(searchtext==''){
        alert("输入不能为空！")
    }else{
        if(myselect=='药品名称查询'){
            page1(ndcid,searchtext);
        }else if(myselect=='药品条形码查询'){
            query2(ndcid,searchtext);
        }
    }

}
function query2(ndcid,mark) {
    $("#medicine-list").css({"display":"none"});
    $("#medicine-xq").css({"display":"table"});
    $.ajax({
        url: "/medicinal/NonPre/getNonPre",
        data: {"ndcid":ndcid,"mark":mark},
        type: "GET",
        dataType: "json",
        success: function (data) {
            console.log(data)
            $("#medicinal-name").html(data.data.nname);
            $("#fromDrug").html(data.data.fromdrug);
            $("#medicinal-specs").html(data.data.specs);
            $("#indication").html(data.data.indication);
            $("#usetaboo").html(data.data.usetaboo);
            $("#dosageandadministration").html(data.data.dosageandadministration);
            $("#basis").html(data.data.basis);
            $("#batch").html(data.data.batch);
            $("#mark").html(data.data.mark);
            $("#remark").html(data.data.remark);

        },
        error: function (err) {
            alert("出错了")
        }
    });
}