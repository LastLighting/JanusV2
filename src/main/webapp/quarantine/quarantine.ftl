<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Add Pet Passport</title>
</head>
<body>
    <legend>Добавить заболевание</legend>
    <form name="quarantine" action="" method="POST">
        <div class="row">
            <div class="col s12">
                <input type="hidden" name="id" value="${quarantine.id}">
            </div>
            <div class="input-field col s6">
                <input type="text" id="diseases" name="diseases" value="${quarantine.diseases!""}" class="validate">
                <label for="petName">petName</label>
            </div>
            <div class="input-field col s6">
                <input type="text" id="laboratory" name="laboratory" value="${quarantine.laboratory!""}" class="validate">
                <label for="laboratory">laboratory</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input type="text" id="numberOfDays" name="numberOfDays" value="${quarantine.numberOfDays!0}" class="validate">
                <label for="numberOfDays">numberOfDays</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input type="text" id="validUntil" name="validUntil" value="${quarantine.validUntil?string("dd/MM/yyyy")}" class="validate">
                <label for="validUntil">validUntil</label>
            </div>
        </div>
        <@spring.formHiddenInput "quarantine.id" ""/><br/>
        Заболевание: <@spring.formInput "quarantine.diseases" ""/>    <br/>
        Лаборатория: <@spring.formInput "quarantine.laboratory" "" "text"/>    <br/>
        Кол-во дней: <@spring.formInput "quarantine.numberOfDays" "" "text"/>    <br/>
        Адрес лаборатории: <@spring.formInput "quarantine.validUntil" "" "text"/>    <br/>
        <input type="submit" value="Create" />
    </form>
</body>

</html>




<#--@Id-->
<#--@GeneratedValue(strategy= GenerationType.IDENTITY)-->
<#--@Column(name = "id", unique = true, nullable = false)-->
<#--private int id;-->

<#--@Column(name = "laboratory", nullable = false)-->
<#--private String laboratory;-->

<#--@Column(name = "numberOfDays", nullable = false)-->
<#--private int numberOfDays;-->

<#--@OneToOne-->
<#--@JoinColumn(name = "addressOfLaboratory")-->
<#--private Address addressOfLaboratory;-->

<#--@OneToMany(cascade = CascadeType.ALL, mappedBy = "quarantine")-->
<#--List<Disease> diseases;-->