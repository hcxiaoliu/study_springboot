<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>
<body>
银行列表
<table>
    <tr>
        <th>银行id</th>
        <th>银行名称</th>
    </tr>
<#if bank??>
<#if  (bank?size>0)>
<#list bank as b>
<tr>
    <td>${b.bankid}</td>
    <td>${b.bankname}</td>
</tr>
</#list>
</#if>
<#else>
</#if>
</table>
</body>
</html>