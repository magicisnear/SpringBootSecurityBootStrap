$('document').ready(function () {
    $('.table .eBtn').on('click', function (event) {

        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('#idEdit').val(user.id);
            $('#firstNameEdit').val(user.firstName);
            $('#lastNameEdit').val(user.lastName);
            $('#ageEdit').val(user.age);
            $('#passwordEdit').val(user.password);
            $('#rolesEdit').val(user.roles);
        });

        $('#editModal').modal();
    });


    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this)
        modal.find('.modal-title').text('New message to ' + recipient)
        modal.find('.modal-body input').val(recipient)
    });

    $('#exampleModal1').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this)
        modal.find('.modal-title').text('New message to ' + recipient)
        modal.find('.modal-body input').val(recipient)
    });

    $('.table .nBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('#idDelete').val(user.id);
            $('#firstNameDelete').val(user.firstName);
            $('#lastNameDelete').val(user.lastName);
            $('#sexDelete').val(user.sex);
            $('#smokerDelete').prop("checked", user.smoker);
            // $('#adminEdit').val(user.roleAdmin);


        });
        //
        $('#deleteModal').modal();

    });

});


// $('document').ready(function () {
//     $('.table .btnd').on('click', function (event) {
//         event.preventDefault();
//         var href = $(this).attr('href');
//         $.get(href, function (user, status) {
//             $('#idDelete').val(user.id);
//             $('#firstNameDelete').val(user.firstName);
//             $('#passwordEdit').val(user.password);
//             $('#lastNameDelete').val(user.lastName);
//             $('#sexDelete').val(user.sex);
//             $('#smokerDelete').prop("checked", user.smoker);
//             $('#adminDelete').modal();
//         });
//     });
// });