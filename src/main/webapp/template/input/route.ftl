<div class="row">
    <div class="col s6">
        <label for="destination">Пункт назначения</label>
        <input type="text" name="route.destination" id="destination" value="${route.destination!""}" required autofocus/>
    </div>
    <div class="col s6">
        <label for="departure">Пункт отправления</label>
        <input type="text" name="route.departure" id="departure" value="${route.departureDate!""}" required/>
    </div>
</div>
<div class="row">
    <div class="col s12">
        <label for="followingPoints">Пункты следования</label>
        <input type="text" name="route.followingPoints" id="followingPoints" value="${route.followingPoints!""}" required/>
    </div>
</div>
<div class="row">
    <div class="col s3">
        <label for="BorderInspectionPosts">Въездной БИП в ЕС</label>
        <input type="text" name="route.BorderInspectionPosts" id="BorderInspectionPosts"
               value="${route.BorderInspectionPosts!""}" required/>
    </div>
    <div class="col s3">
        <label for="transportType">Тип транспорта</label>
        <input type="text" name="route.transportType" id="transportType" value="${route.transportType!""}" required/>
    </div>
    <div class="col s3">
        <label for="transportID">Идентификатор транспорта</label>
        <input type="text" name="route.transportID" id="transportID" value="${route.transportID!""}" required/>
    </div>
</div>
