<!DOCTYPE html>
<html lang="ru">
<head>
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style.css'/>

    <meta charset="utf-8">

    <title>Home</title>
</head>
<body>
<script type="text/javascript" rel="script" src="/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" rel="script" src="/resources/materialize/js/materialize.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/combodate.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/fastpassport.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/moment.js"></script>


<form name="passport" action="" method="POST">
    <div id="block_passport" class="row">
        <div class="center-block col s12">
            <div id="block_passport" class="col s12">
                <div class="center-block row">
                <#include "/template/input/passport.ftl">
                    <div class="row">
                        <button class="btn waves-effect waves-light" type="submit" name="action">Создать</button>
                    </div>
                </div>
            </div>
        </div>


</form>

</body>
</html>

