$(document).ready(function(){
    $("#picture-carousel0>div:nth-child(2)").css("display","none");
    $("#picture-carousel0>div:nth-child(3)").css("display","none");
    $("#picture-carousel0>div:nth-child(4)").css("display","none");
    $("#picture-carousel0>div:nth-child(5)").css("display","none");
    $("#circle1>div:nth-child(1)").css("backgroundColor","#0C75BB");
});
var i=2;
function change(){
    // 每变化一次想让所有图片清除，并让所有小圆点恢复初始状态
    $("#picture-carousel0>div:lt(5)").css("display","none");
    $("#circle1>div").css("backgroundColor","rgb(209, 195, 195)");
    if(i>5){
        i=1;
    }
    //第i个图片显示，第i个按钮变色
    $("#picture-carousel0>div:nth-child("+i+")").css("display","block");
    $("#circle1>div:nth-child("+i+")").css("backgroundColor","#0C75BB");
    i++;
}
function buttonl(i){
    $("#picture-carousel0>div:lt(5)").css("display","none");
    $("#circle1>div").css("backgroundColor","rgb(209, 195, 195)");
    $("#picture-carousel0>div:nth-child("+i+")").css("display","block");
    $("#circle1>div:nth-child("+i+")").css("backgroundColor","#0C75BB");
}
window.setInterval("change()",5000);

function tzxmxxk(){
    location.href="tzxmxxk.html";
}