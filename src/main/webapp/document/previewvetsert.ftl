<#import "/spring.ftl" as spring/>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Просмотр Ветеринарного сертификата</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/pgwslider.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style_child.css'/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<script type="text/javascript" rel="script" src="/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/office.js"></script>

<#include "/template/navbar.ftl">

<div class="section">
    <div class="col s12">
        <div class="row">
        <#if vetSert.status=="CREATED">
            <a href="/docs/vet/doc/${vetDoc.id}/send" class="waves-effect waves-light btn">
                Отправить зарубежной стране
            </a>
        </#if>
        </div>
        <div class="row">
        <#include "/template/output/vetsertpreview.ftl"/>
        </div>
    </div>
</div>
</body>
</html>