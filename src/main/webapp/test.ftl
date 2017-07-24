<#-- @ftlvariable name="currentUser" type="topprogersgroup.entity.CurrentUser" -->


<!DOCTYPE html>
<html lang="ru">
<head>
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style_child.css'/>
    <meta charset="utf-8">

    <title>Home</title>
</head>
<body>
<script type="text/javascript" rel="script" src="/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" rel="script" src="/resources/materialize/js/materialize.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/combodate.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/fastpassport.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/moment.js"></script>

<#include "/template/navbar.ftl">

<form id="diseasesForm" method="post" class="form-horizontal">
    <div class="center-block">
        <div class="row">
            <div class="form-group">
                <div class="input-field col s12">
                    <input type="text" id="diseases" name="diseases" value="${quarantine.diseases!""}" class="validate">
                </div>
                <button type="button" class="btn btn-default addButton">Добавить</button>
            </div>

            <div class="form-group" id="diseasesTemplate">
                <div class="input-field col s12">
                    <input type="text" name="diseases" value="${quarantine.diseases!""}" class="validate">
                </div>
                <button type="button" class="btn btn-default removeButton">Удалить</button>
            </div>

        </div>
    </div>
</form>

</body>
</html>