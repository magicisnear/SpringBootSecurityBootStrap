$('document').ready(function () {


    $('.table .eBtn').on('click', function (event) {

        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('.myForm #id').val(user.id);
            $('.myForm #Username').val(user.name);
            $('.myForm #lastName').val(user.lastName);
            $('.myForm #age').val(user.age);
            $('.myForm #email').val(user.email);
            $('.myForm #roles').val(user.roles);
        });

        $('.myForm #exampleModal').modal();
    });

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('.myForm1 #id').val(user.id);
            $('.myForm1 #Username').val(user.name);
            $('.myForm1 #lastName').val(user.lastName);
            $('.myForm1 #age').val(user.age);
            $('.myForm1 #email').val(user.email);
            $('.myForm1 #roles').val(user.roles);
        });


        $('#exampleModal1 #delRef').attr('href', href);

        $('#exampleModal1').modal();
    });


});



