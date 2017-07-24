<#import "/spring.ftl" as spring/>

<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Заявка на вывоз</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style_child.css'/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<script type="text/javascript" rel="script" src="/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" rel="script" src="/resources/materialize/js/materialize.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/combodate.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/office.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/moment.js"></script>
<#include "/template/navbar.ftl">

<form name="/create" id="createForm" action="" method="POST">
    <div class="row main_block">
        <div class="col s12 block-top">
            <ul class="tabs">
                <li class="tab col"><a class="active" href="#block_route">Маршрут</a></li>
                <li class="tab col"><a href="#block_bid">Заявка на Ветеринарное свидетельство </a></li>
            </ul>
        </div>

        <div id="block_route" class="col s12">
            <div class="center-block">
            <#include "/template/input/route.ftl">
            </div>
        </div>

        <div id="block_bid" class="col s12">
            <div class="center-block">
            <#include "/template/input/bid.ftl">
                <input class="btn btn-primary" type="submit" value="Создать">
            </div>
        </div>

    </div>
</form>
</body>
</html>