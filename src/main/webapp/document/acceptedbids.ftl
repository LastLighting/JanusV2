<#import "/spring.ftl" as spring/>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Принятые заявки</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style_child.css'/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<script type="text/javascript" rel="script" src="/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/office.js"></script>

<#include "/template/navbar.ftl">
<#--Поиск принятых заявок-->
<#include "/template/search/findacceptedbids.ftl">

<div class="section">
    <#if bidList??>
        <#list bidList as bid>
        <#--<a href="/docs/accepted/bid/${bid.id}">-->
            <div class="row">
                <div class="col s6">
                    Статус: ${bid.status!""}<br/>
                    Количество петомцев: ${bid.countPet!0}<br/>
                    Количество мест под петомцев: ${bid.countSeats!0}<br/>
                    Дата отправления: ${(bid.departureDate?string("dd-MM-yyyy"))!""}<br/>
                </div>
                <div class="col s6">
                    Пункт назначения: ${bid.route.destination!""}<br/>
                    Пукты следования: ${bid.route.followingPoints!""}<br/>
                    Пункт отправления: ${bid.route.departure!""}<br/>
                    Въездной БИП в ЕС: ${bid.route.BorderInspectionPosts!""}<br/>
                    Тип транспорта: ${bid.route.transportType!""}<br/>
                </div>
                <div class="col s2">
                    <a href="/docs/accepted/bid/${bid.id}">Оформить Вет. свидетельство</a>
                </div>
            </div>
        <#--</a>-->
        </#list>

        <ul class="pagination">
            <li class="disabled"><a href="/docs/accepted/page/${numberPage-1}"><i class="material-icons">chevron_left</i></a></li>
            <li class="active"><a href="/docs/accepted/page/${numberPage}">${numberPage}</a></li>
            <li class="waves-effect"><a href="/docs/accepted/page/${(numberPage+1)}">${(numberPage+1)}</a></li>
            <li class="waves-effect"><a href="/docs/accepted/page/${(numberPage+2)}">${(numberPage+2)}</a></li>
            <li class="waves-effect"><a href="/docs/accepted/page/${(numberPage+3)}">${(numberPage+3)}</a></li>
            <li class="waves-effect"><a href="/docs/accepted/page/${(numberPage+4)}">${(numberPage+4)}</a></li>
            <li class="waves-effect"><a href="/docs/accepted/page/${(numberPage+1)}"><i class="material-icons">chevron_right</i></a></li>
        </ul>
    </#if>

</div>

<footer>
    footer
</footer>
</body>
</html>

