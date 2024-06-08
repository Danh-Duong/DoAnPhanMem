//lam slider
window.onload = function () {

    var blockslide = document.querySelector('.block_slider');
    //lay the khoi chua slider
    var listimage = document.querySelectorAll('.list_item_slider');
    //console.log(listimage);//lay the chua ds image


    //tien hanh lay ds image
    var numberimage = document.querySelectorAll('.content_1_image img').length;
    //console.log(numberimage);
    var i = 0;
    //lay chi muc 
    var index_img = document.querySelectorAll('.number--img--item');
    var index_img2 = document.querySelectorAll('.index2');

    //tien hanh tao slider
    setInterval(function () {
        if (i == 4) {
            i = 0;
        }
        //xoa class cho cac item truoc do
        document.querySelector('.chooseimg').classList.remove('chooseimg');
        document.querySelector('.chooseimg2').classList.remove('chooseimg2');
        //lay chieu rong 1 buc hinh
        var lengthimg = document.querySelector('.content_1_image img').width;
        listimage[0].style.transform = `translateX(${lengthimg * -1 * i}px)`;
        listimage[1].style.transform = `translateX(${lengthimg * -1 * i}px)`;
        index_img[i].classList.add('chooseimg');
        index_img2[i].classList.add('chooseimg2');
        i++;
    }, 3000);
    //hieu ung thanh search bien mat
    //ham an

    //js for login

    //button send OTP
    let register_button_otp = document.querySelector('#register_button_otp');
    register_button_otp.addEventListener('click', function (e) {
        e.preventDefault();
    });
    //an hien password
    var hidepass = document.querySelectorAll('.fa-eye-slash');
    var openpass = document.querySelectorAll('.fa-eye');
    //lay input= pass
    var inputpass = document.querySelectorAll('input[type="password"]');

    hidepass[0].addEventListener('click', function () {
        hidepass[0].classList.toggle('close');
        openpass[0].classList.toggle('close');
        inputpass[0].setAttribute('type', 'text');
    });
    openpass[0].addEventListener('click', function () {
        hidepass[0].classList.toggle('close');
        openpass[0].classList.toggle('close');
        inputpass[0].setAttribute('type', 'password');
    });
    var close_login = document.querySelectorAll('.fa-xmark');
    var loginbox = document.querySelector('.applogin');
    close_login[0].addEventListener('click', function () {
        loginbox.classList.add('close');
    });
    //dang ky
    var register_box = document.querySelector('.register_pass');
    var open_register = document.querySelector('.register_account');
    console.log(open_register);
    open_register.addEventListener('click', function () {
        register_box.classList.remove('close');
    });
    hidepass[1].addEventListener('click', function () {
        hidepass[1].classList.toggle('close');
        openpass[1].classList.toggle('close');
        inputpass[1].setAttribute('type', 'text');
    });
    openpass[1].addEventListener('click', function () {
        hidepass[1].classList.toggle('close');
        openpass[1].classList.toggle('close');
        inputpass[1].setAttribute('type', 'password');
    });
    var close_login = document.querySelectorAll('.fa-xmark');

    close_login[1].addEventListener('click', function () {
        register_box.classList.add('close');
    });
    //quên mật khẩu
    let forgot_pass = document.querySelector('.fogot_pass');
    let forgot_box = document.querySelector('.forgot_pass');
    forgot_pass.addEventListener('click', () => {
        forgot_box.classList.remove('close');
    });
    hidepass[2].addEventListener('click', function () {
        hidepass[2].classList.toggle('close');
        openpass[2].classList.toggle('close');
        inputpass[2].setAttribute('type', 'text');
    });
    openpass[2].addEventListener('click', function () {
        hidepass[2].classList.toggle('close');
        openpass[2].classList.toggle('close');
        inputpass[2].setAttribute('type', 'password');
    });
    var close_login = document.querySelectorAll('.fa-xmark');

    close_login[2].addEventListener('click', function () {
        forgot_box.classList.add('close');
    });


    var openlogin2 = document.querySelector('#account2');
    var openlogin = document.querySelector('#account');
    var login = document.querySelector('.applogin');
    var login_box = document.querySelector('.login_box');
    openlogin.addEventListener('click', function () {
        login.classList.remove('close');

    });
    openlogin2.addEventListener('click', function () {
        login.classList.remove('close');

    });
    try {
        //an hien thong bao
        let chuongthongbao = document.getElementById("user_announce_icon");
        let thanhthongbao = document.getElementsByClassName("app_announce");
        let dongthanhthongbao = document.getElementById("app_announce_close");

        console.log(chuongthongbao);
        console.log(thanhthongbao);
        chuongthongbao.addEventListener('click', function () {
            thanhthongbao[0].classList.remove('close');
        });
        dongthanhthongbao.addEventListener('click', function () {
            thanhthongbao[0].classList.add('close');
        });

        //lam kiem tra thong bao da doc hay chua
        let itemthongbao = document.getElementsByClassName("app_list_announce_item");
        let thongbaochuadoc = itemthongbao.length;
        let n = thongbaochuadoc;
        let hienthisothongbao = document.getElementById("number_announce");
        //ds icon trang thai
        let icontrangthai = document.getElementsByClassName("announce_chua_doc");
        //gan so luong thong bao len icon
        hienthisothongbao.innerText = thongbaochuadoc;
        for (let i = 0; i < thongbaochuadoc; i++) {
            itemthongbao[i].addEventListener('click', function () {
                n = n - 1;
                hienthisothongbao.innerText = n;
                icontrangthai[i].style.display = 'none';
            })
        }


    }catch(error)
    {
        console.log(error);
    }



    //an hien edit thong tin ca nhan admin
    let edit_form_admin = document.querySelector('.edit_info')
    //lay cac hang trong bang
    var rows = document.querySelectorAll('tr');
    var array_rows = Array.from(rows);
    // lay cac btn  edit 
    var btn_edits = document.querySelectorAll('.btn_edit');
    var array_btn_edit = Array.from(btn_edits);

    for (var i = 0; i < array_btn_edit.length; i++) {
        //lay cot trong hang
        let columns = array_rows[i + 1].querySelectorAll('td');
        array_btn_edit[i].addEventListener('click', function () {
            console.log(this);
            console.log(columns[2].textContent);
            //lay input
            var inputs = document.querySelectorAll('.edit_input input');
            for (let j = 0; j < 4; j++) {
                inputs[j].value = columns[j + 1].textContent;
            };
            //gan check box edit
            console.log(columns[5].querySelector('.btn_check_active').value);//nếu checked thì trả về on
            let input_check_edit = document.querySelector('.edit_input_status input');

            if (columns[5].querySelector('.btn_check_active').value == "on") {
                input_check_edit.setAttribute('checked', 'checked');
            }
            edit_form_admin.classList.remove('close');
        });
    }
    close_login[3].addEventListener('click', function () {
        edit_form_admin.classList.add('close');
    });

    //rang buoc check box tabel
    let btn_check_actives = document.querySelectorAll('.btn_check_active');
    btn_check_actives.forEach(function (btn) {
        btn.setAttribute('checked', 'checked');
        btn.addEventListener('click', function (e) {
            e.preventDefault();
        });
    });

    ////an hien add thong tin ca nhan admin
    let add_form_admin = document.querySelector('.add_info');
    try {
        let btn_add_show = document.querySelector('#button_add');
        btn_add_show.addEventListener('click', () => {
            add_form_admin.classList.remove('close');
        });
        close_login[4].addEventListener('click', function () {
            add_form_admin.classList.add('close');
        });
    }
    catch (error) {
        console.log(error);
    }




    ///tao bai đăng nhan vien
    //lay input
    let input_file_baidang = document.querySelector('#dangbai_image');
    //lay button
    let button_image_baidang = document.querySelector('#dangbai_image_button');
    //laybutton p
    let button_image_p = document.querySelector('#dangbai_image_button p');
    let button_image_i = document.querySelector('#dangbai_image_button i');
    button_image_baidang.addEventListener('click', function (e) {
        input_file_baidang.click();
        e.preventDefault();
    });
    input_file_baidang.addEventListener('change', function (event) {
        const file = event.target.files[0];
        const fileName = file.name;
        console.log(fileName);
        if (file) {
            //button_image_baidang.style.display = 'none';
            const reader = new FileReader();

            reader.onload = function (event) {
                //image_baidang.src = event.target.result;
                button_image_p.textContent = 'Thay đổi';
                button_image_p.style.color = 'white';
                button_image_i.style.color = 'white';
                button_image_baidang.style.backgroundImage = `url("${event.target.result}")`;
                button_image_baidang.style.backgroundSize = 'cover';
            };

            reader.readAsDataURL(file);
        }
    });

}

