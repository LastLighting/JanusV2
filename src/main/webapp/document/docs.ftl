<#import "/spring.ftl" as spring/>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Паспорт питомца</title>
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
<script type="text/javascript" rel="script" src="/resources/js/pgwslider.js"></script>
<#include "/template/navbar.ftl">

<div class="section">
<#list bidList as bid>
    <a href="/docs/create/${bid.id}">
        <div class="row">

            <div class="col s6">
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
        </div>
    </a>
</#list>
</div>

<ul class="pagination">
    <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
    <li class="active"><a href="/docs/${numberPage}">1</a></li>
    <li class="waves-effect"><a href="/docs/${(numberPage+1)}">2</a></li>
    <li class="waves-effect"><a href="/docs/${(numberPage+2)}">3</a></li>
    <li class="waves-effect"><a href="/docs/${(numberPage+3)}">4</a></li>
    <li class="waves-effect"><a href="/docs/${(numberPage+4)}">5</a></li>
    <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
</ul>

<footer>
    footer
</footer>
</body>
</html>

