<div class="row">
    <div class="col s12 m4">
        <label>Количество питомцев</label>
        <p>${bid.countPet!0}</p>
    </div>
    <div class="col s12 m4">
        <label>Количество мест под питомцев</label>
        <p>${bid.countSeats!0}</p>
    </div>
    <div class="col s12 m4">
        <label>Дата отправления</label>
        <p>${(bid.departureDate?string("dd-MM-yyyy"))!""}</p>
    </div>
</div>