alert("我是外部Js文件");
// var a = 3;
// alert(a);
// a="abc";//没有字符概念，只有字符串"abc"='abc'等效
// alert(a);
var n1=1;
var n2=1.1;
var n3=NaN;
var flag=true;
var obj1=null;
var obj2=undefined;
var obj3;
var a="abc";
var b='abc';
//输出到页面
document.write(n1+"---"+typeof(n1) +"<br>");
document.write(n2+"---"+typeof(n2) +"<br>");
document.write(n3+"---"+typeof(n3) +"<br>");
document.write("<hr>")
document.write(flag+"---"+typeof(flag) +"<br>");
document.write(obj1+"---"+typeof(obj1) +"<br>");
document.write(obj2+"---"+typeof(obj2) +"<br>");
document.write(obj3+"---"+typeof(obj3) +"<br>");
document.write(a+"---"+typeof(a) +"<br>");
document.write(b+"---"+typeof(b) +"<br>");

document.write("<table align='center'>");
for (var i = 1; i <=9; i++) {
    document.write("<tr>");
    for (var j = 1; j <= i; j++) {
        document.write("<td>");
        document.write(i+" * "+j+" = "+(i*j)+"&nbsp&nbsp&nbsp");
        document.write("</td>");
    }
    // document.write("<br>")
    document.write("</tr>")
}
document.write("</table>");

