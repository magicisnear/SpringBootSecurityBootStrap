$('document').ready(function () {
    $('.table .eBtn').on('click', function (event) {

        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('#recipient-name2').val(user.name);
            $('#recipient-name3').val(user.lastName);
            $('#recipient-name4').val(user.age);
            $('#recipient-name5').val(user.email);
            $('#recipient-name6').val(user.password);
            $('#recipient-name7').val(user.role);
        });

        $('#exampleModal').modal();
    });
});
