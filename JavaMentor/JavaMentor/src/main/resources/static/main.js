$('document').ready(function () {


    $('.table .eBtn').on('click', function (event) {

        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('.myForm #firstNameEdit').val(user.name);
            $('.myForm #lastNameEdit').val(user.lastName);
            $('.myForm #ageEdit').val(user.age);
            $('.myForm #emailEdit').val(user.email);
            $('.myForm #passwordEdit').val(user.password);
            $('.myForm #roleEdit').val(user.role);
        });

        $('.myForm #exampleModal').modal();
    });




});



