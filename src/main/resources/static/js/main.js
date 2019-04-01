
$(document).ready(function () {
    $("#Login").validate({
        rules: {
            password: {
                required: true,
                minlength: 8
            },
            username: {
                required: true,
                email: true
            }
        },
        messages: {
            password: {
                required: 'Please enter password!',
                minlength: 'Password must be more than 8 characters!'
            },
            username: {
                required: "Please enter email!"
            }
        }
    });
});

$(document).ready(function () {
    $("#Register").validate({
        rules: {
            name: {
                required: true,
                minlength: 2,
                maxlength: 10
            },
            password: {
                required: true,
                minlength: 8
            },
            confirm_password: {
                required: true,
                minlength: 8,
                equalTo: "#password"
            },
            username: {
                required: true,
                email: true
            }
        },
        messages: {
            name: {
                required: "Please enter your name!",
                minlength: "Name must be more than 2 characters!",
                maxlength: "Name is maximum 10 characters!"
            },
            password: {
                required: 'Please enter password!',
                minlength: 'Password must be more than 8 characters!'
            },
            confirm_password: {
                required: 'Please enter confirmation password!',
                minlength: 'Password must be more than 8 characters!',
                equalTo: 'The password and confirmation password do not match!'
            },
            username: {
                required: "Please enter email!"
            }
        }
    });
});

$(document).ready(function () {
    $("#DemoJqueryValidation").validate({
        rules: {
            name: {
                required: true,
                minlength: 2,
                maxlength: 10
            },
            password: {
                required: true,
                minlength: 8
            },
            username: {
                required: true,
                email: true
            }
        },
        messages: {
            name: {
                required: "Please enter your name!",
                minlength: "Name must be more than 2 characters!",
                maxlength: "Name is maximum 10 characters!"
            },
            password: {
                required: 'Please enter password!',
                minlength: 'Password must be more than 8 characters!'
            },
            username: {
                required: "Please enter email!"
            }
        }
    });
});


