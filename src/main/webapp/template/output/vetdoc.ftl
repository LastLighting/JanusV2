<div class="row">
    <div class="col s12 m4">
        <label>Номер свидетельства</label>
        <br/>
        <p>${vetDoc.number!0}</p>
    </div>
    <div class="col s12 m4">
        <label>Дата оформления свидетельства</label>
        <p>${(vetDoc.issueDate?string("dd/MM/yyyy"))!""}</p>
    </div>
    <div class="col s12 m4">
        <label>Время пребывания животного в РФ</label>
        <p>${vetDoc.residenceTime!0}</p>
    </div>
</div>
<div class="row">
    <div class="col s12 m6">
        <label>Государственная Ветеринарная Служба</label>
        <br/>
        <p>${vetDoc.stateVeterinaryService.serviceName!""}</p>
    </div>
    <div class="col s12 m6">
        <label>Свидетельство оформил</label>
        <p>${vetDoc.employee.firstName!""} ${vetDoc.employee.lastName!""}</p>
    </div>
</div>