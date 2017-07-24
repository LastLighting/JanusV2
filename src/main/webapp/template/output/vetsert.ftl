<div class="row">
    <div class="col s12 m4">
        <label>Номер сертификата</label>
        <br/>
        <p>${vetSert.number!0}</p>
    </div>
    <div class="col s12 m4">
        <label>Дата оформления сертификата</label>
        <br/>
        <p>${(vetSert.issueDate?string("dd/MM/yyyy"))!""}</p>
    </div>
    <div class="col s12 m4">
        <label>Статус</label>
        <br/>
        <p>${vetSert.status!""}</p>
    </div>
</div>
<div class="row">
    <div class="col s12 m4">
        <label>Цетральный компетентный орган</label>
        <br/>
        <p>${vetSert.centralCompetentAuthority!""}</p>
    </div>
    <div class="col s12 m4">
        <label>Местный компетентный орган</label>
        <p>${vetSert.localCompetentAuthority!""}</p>
    </div>
    <div class="col s12 m4">
        <label>Место оформления</label>
        <p>${vetSert.registrationPlace!""}</p>
    </div>
</div>
