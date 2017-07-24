<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Add Pet Passport</title>
</head>
<body>

<div>
    <fieldset>
        <legend>Добавить Хозяина</legend>
        <form name="owner" action="" method="POST">
            <div class="row">
                <div class="col s12">
                    <input type="text" name="numberAndSeriesOfPassport" value="${owner.numberAndSeriesOfPassport}">
                </div>
                <div class="input-field col s6">
                    <input type="text" id="firstName" name="firstName" value="${owner.firstName!""}" class="validate">
                    <label for="firstName">firstName</label>
                </div>
                <div class="input-field col s6">
                    <input type="text" id="lastName" name="lastName" value="${owner.lastName!""}" class="validate">
                    <label for="lastName">lastName</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input type="text" id="patronymic" name="patronymic" value="${owner.patronymic!""}" class="validate">
                    <label for="patronymic">patronymic</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input type="text" id="dateOfBirth" name="dateOfBirth" value="${owner.dateOfBirth?string("dd/MM/yyyy")}" class="validate">
                    <label for="dateOfBirth">dateOfBirth</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input type="text" id="phoneNumber" name="phoneNumber" value="${owner.phoneNumber!""}" class="validate">
                    <label for="phoneNumber">phoneNumber</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input type="text" id="address" name="address" value="${owner.address!""}" class="validate">
                    <label for="address">address</label>
                </div>
            </div>
    </fieldset>
</div>

</body>

</html>


<#--@Id-->
<#--@Column(name = "numberAndSeriesOfPassport", unique = true, nullable = false)-->
<#--private String numberAndSeriesOfPassport;-->

<#--@Column(name = "firstName", nullable = false)-->
<#--private String firstName;-->

<#--@Column(name = "lastName", nullable = false)-->
<#--private String lastName;-->

<#--//отчество-->
<#--@Column(name = "patronymic", nullable = false)-->
<#--private String patronymic;-->

<#--@Column(name = "gender", nullable = false)-->
<#--private boolean gender;-->

<#--@Column(name = "dateOfBirth", nullable = false)-->
<#--@Temporal(value=TemporalType.DATE)-->
<#--private Date dateOfBirth;-->

<#--@Column(name = "phoneNumber", nullable = false)-->
<#--private String phoneNumber;-->

<#--@OneToOne-->
<#--@JoinColumn(name = "address_id")-->
<#--private Address address;-->

<#--@OneToOne(cascade = CascadeType.ALL, mappedBy = "owner")-->
<#--private Passport passport;-->
