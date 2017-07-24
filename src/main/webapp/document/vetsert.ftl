<#import "/spring.ftl" as spring/>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Создать Международный Ветеренарный сертификат</title>
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
<form action=""  method="POST">
<div class="section">
    <div class="row center-block">
        <fieldset class="card table">
            <div class="row">
                <div class="col s12">
                    <div class="col s6">
                        <label class="flow-text"> Номер сертификата:</label>
                        <input type="text" name="number" id="number" value="${vetSert.number!0}"> <br/>
                    </div>
                    <div class="col s6">
                        <label class="flow-text"> Цетральный компетентный орган:</label>
                        <input type="text" name="centralCompetentAuthority"
                               id="centralCompetentAuthority"
                               value=" ${vetSert.centralCompetentAuthority!""}"><br/>
                    </div>
                </div>
                <div class="col s12">
                    <div class="col s6">
                        <label class="flow-text"> Местный компетентный орган:</label>
                        <input type="text" name="localCompetentAuthority"
                               id="localCompetentAuthority"
                               value="${vetSert.localCompetentAuthority!""}"><br/>
                    </div>
                    <div class="col s6">
                        <label class="flow-text"> Место оформления:</label>
                        <input type="text" name="registrationPlace" id="registrationPlace"
                               value="${vetSert.registrationPlace!""}"><br/>
                    </div>
                </div>
                <div class="col s12">
                    <input class="btn btn-primary" type="submit" value="Отправить данные">
                </div>
            </div>
        </fieldset>
    </div>
</div>
</form>
</body>
</html>

