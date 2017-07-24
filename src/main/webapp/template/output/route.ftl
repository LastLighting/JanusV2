<#if route??>
<div class="row">
    <div class="col s4">
        <label>Пункт назначения</label>
        <p>${route.destination!""}</p>
    </div>
    <div class="col s4">
        <label>Пункт отправления</label>
        <p>${route.departureDate!""}</p>
    </div>
    <div class="col s4">
        <label>Пункты следования</label>
        <p>${route.followingPoints!""}</p>
    </div>
</div>

<div class="row">
    <div class="col s4">
        <label>Въездной БИП в ЕС</label>
        <p>${route.BorderInspectionPosts!""}</p>
    </div>
    <div class="col s4">
        <label>Тип транспорта</label>
        <p>${route.transportType!""}</p>
    </div>
    <div class="col s4">
        <label>Идентификатор транспорта</label>
        <p>${route.transportID!""}</p>
    </div>
</div>
<div class="row">
    <div class="col s12">
        <table class="striped responsive-table">
            <thead>
            <tr>
                <th>Название пропускного пункта</th>
                <th>Адрес</th>
                <th>Номер телефона</th>
                <th>Испектор</th>
            </tr>
            </thead>
            <tbody>
                <#list route.checkPoints as chechPoint>
                <tr>
                    <td>${chechPoint.cpName}</td>
                    <td>${chechPoint.address}</td>
                    <td>${chechPoint.phoneNumber}</td>
                    <td>${chechPoint.inspector.firstName} ${chechPoint.inspector.lastName}</td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>
</#if>
