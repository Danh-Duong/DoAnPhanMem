window.onload = function () {
    try {
        //lay name
        let bieumau_username = document.querySelectorAll('.bieumau_username');
        console.log(bieumau_username.length);
        //lay mui ten
        let fa_caret_down = document.querySelectorAll('.fa-caret-down');
        console.log(fa_caret_down);
        //lay ds bieu mau cua nguoi dung
        let category_bieumau = document.querySelectorAll('.category_bieumau');

        let status = false;
        //ham dng mo
        function kichhoat(status, i) {
            if (status == true) {
                category_bieumau[i].classList.remove('close');
            }
            else {
                category_bieumau[i].classList.add('close');
            }
        };
        for (let i = 0; i < bieumau_username.length; i++) {
            bieumau_username[i].addEventListener('click', function () {
                if (status == false) {
                    status = true;
                    kichhoat(status, i);
                    fa_caret_down[i].classList.add('animated');
                }
                else {
                    status = false;
                    kichhoat(status, i);
                    fa_caret_down[i].classList.remove('animated');
                }
            });
        }



    }
    catch (error) {
        console.log(error);
    };



    // hien thi cac form cua user cho nhan vien
    try {
        // bbutton bieumau
        let bieumau_tamtru = document.querySelectorAll('.bieumau_tamtru');
        let bieumau_tamvang = document.querySelectorAll('.bieumau_tamvang');
        let bieumau_khaisinh = document.querySelectorAll('.bieumau_khaisinh');
        let bieumau_khaitu = document.querySelectorAll('.bieumau_khaitu');
         let bieumau_tamtru2 = document.querySelectorAll('.bieumau_tamtru2');
        let bieumau_tamvang2 = document.querySelectorAll('.bieumau_tamvang2');
        let bieumau_khaisinh2 = document.querySelectorAll('.bieumau_khaisinh2');
        let bieumau_khaitu2 = document.querySelectorAll('.bieumau_khaitu2');
        // add envent cho cac list
        let status_list_tamtru = false;
        let status_list_khaisinh = false;
        let status_list_khaitu = false;
        let status_list_tamvang = false;
        // lay button trong líst form	
        let list_tamtru_form = document.querySelector('.list_tamtru_form');
        let list_tamvang_form = document.querySelector('.list_tamvang_form');
        let list_khaisinh_form = document.querySelector('.list_khaisinh_form');
        let list_khaitu_form = document.querySelector('.list_khaitu_form');
          let list_tamtru_form2 = document.querySelector('.list_tamtru_form2');
        let list_tamvang_form2 = document.querySelector('.list_tamvang_form2');
        let list_khaisinh_form2 = document.querySelector('.list_khaisinh_form2');
        let list_khaitu_form2 = document.querySelector('.list_khaitu_form2');
        function show_list_form_employ(status_list_tamtru, status_list_khaisinh, status_list_khaitu, status_list_tamvang) {
            list_tamtru_form.classList.add('close');
            list_tamvang_form.classList.add('close');
            list_khaisinh_form.classList.add('close');
            list_khaitu_form.classList.add('close');
              list_tamtru_form2.classList.add('close');
            list_tamvang_form2.classList.add('close');
            list_khaisinh_form2.classList.add('close');
            list_khaitu_form2.classList.add('close');
            if (status_list_tamtru == true) {
                list_tamtru_form.classList.remove('close');
            }
            if (status_list_tamvang == true) {
                list_tamvang_form.classList.remove('close');
            }
            if (status_list_khaisinh == true) {
                list_khaisinh_form.classList.remove('close');
            }
            if (status_list_khaitu == true) {
                list_khaitu_form.classList.remove('close');
            }

        }
         function show_list_form_employ2(status_list_tamtru, status_list_khaisinh, status_list_khaitu, status_list_tamvang) {
             list_tamtru_form2.classList.add('close');
            list_tamvang_form2.classList.add('close');
            list_khaisinh_form2.classList.add('close');
            list_khaitu_form2.classList.add('close');
             list_tamtru_form.classList.add('close');
            list_tamvang_form.classList.add('close');
            list_khaisinh_form.classList.add('close');
            list_khaitu_form.classList.add('close');
            if (status_list_tamtru == true) {
                 list_tamtru_form2.classList.remove('close');
            }
            if (status_list_tamvang == true) {
                list_tamvang_form2.classList.remove('close');
            }
            if (status_list_khaisinh == true) {
               list_khaisinh_form2.classList.remove('close');
            }
            if (status_list_khaitu == true) {
                list_khaitu_form2.classList.remove('close');
            }

        }
        bieumau_tamvang.forEach((item) => {
            item.addEventListener('click', () => {

                // dong bieu mau
                status_tamtru = false;
                status_khaisinh = false;
                status_khaitu = false;
                status_tamvang = false;
                show_form_employ(status_tamtru, status_khaisinh, status_khaitu, status_tamvang);

                // end
                status_list_tamtru = false;
                status_list_khaisinh = false;
                status_list_khaitu = false;
                status_list_tamvang = true;
                show_list_form_employ(status_list_tamtru, status_list_khaisinh, status_list_khaitu, status_list_tamvang);
            });
        });
        bieumau_khaitu.forEach((item) => {
            item.addEventListener('click', () => {
                // dong bieu mau
                status_tamtru = false;
                status_khaisinh = false;
                status_khaitu = false;
                status_tamvang = false;
                show_form_employ(status_tamtru, status_khaisinh, status_khaitu, status_tamvang);

                // end
                status_list_tamtru = false;
                status_list_khaisinh = false;
                status_list_khaitu = true;
                status_list_tamvang = false;
                show_list_form_employ(status_list_tamtru, status_list_khaisinh, status_list_khaitu, status_list_tamvang);
            });
        });
        bieumau_tamtru.forEach((item) => {
            item.addEventListener('click', () => {
                // dong bieu mau
                status_tamtru = false;
                status_khaisinh = false;
                status_khaitu = false;
                status_tamvang = false;
                show_form_employ(status_tamtru, status_khaisinh, status_khaitu, status_tamvang);

                // end
                status_list_tamtru = true;
                status_list_khaisinh = false;
                status_list_khaitu = false;
                status_list_tamvang = false;
                show_list_form_employ(status_list_tamtru, status_list_khaisinh, status_list_khaitu, status_list_tamvang);
            });
        });
        bieumau_khaisinh.forEach((item) => {
            item.addEventListener('click', () => {
                // dong bieu mau
                status_tamtru = false;
                status_khaisinh = false;
                status_khaitu = false;
                status_tamvang = false;
                show_form_employ(status_tamtru, status_khaisinh, status_khaitu, status_tamvang);

                // end
                status_list_tamtru = false;
                status_list_khaisinh = true;
                status_list_khaitu = false;
                status_list_tamvang = false;
                show_list_form_employ(status_list_tamtru, status_list_khaisinh, status_list_khaitu, status_list_tamvang);
            });
        });
        bieumau_khaisinh2.forEach((item) => {
            item.addEventListener('click', () => {
                // dong bieu mau
                status_tamtru2 = false;
                status_khaisinh2 = false;
                status_khaitu2 = false;
                status_tamvang2 = false;
                show_form_employ(status_tamtru2, status_khaisinh2, status_khaitu2, status_tamvang2);

                // end
                status_list_tamtru2 = false;
                status_list_khaisinh2 = true;
                status_list_khaitu2 = false;
                status_list_tamvang2 = false;
                show_list_form_employ2(status_list_tamtru2, status_list_khaisinh2, status_list_khaitu2, status_list_tamvang2);
            });
        });





        // Lay list folder
        let folder_tamtru = document.querySelectorAll('.list_tamtru_form .folder');
        let folder_tamvang = document.querySelectorAll('.list_tamvang_form .folder');
        let folder_khaisinh = document.querySelectorAll('.list_khaisinh_form .folder');
        let folder_khaitu = document.querySelectorAll('.list_khaitu_form .folder');
        //lay cac fom
        let form_tamtru = document.querySelector('.form_tamtru_employ');
        let form_khaisinh = document.querySelector('.form_khaisinh');
        let form_khaitu = document.querySelector('.form_khaitu');
        let form_tamvang = document.querySelector('.form_tamvang');
        // add event cho cac form
        let status_tamtru = false;
        let status_khaisinh = false;
        let status_khaitu = false;
        let status_tamvang = false;
       
        function show_form_employ(status_tamtru, status_khaisinh, status_khaitu, status_tamvang) {
            form_tamtru.classList.add('close');
            form_khaisinh.classList.add('close');
            form_khaitu.classList.add('close');
            form_tamvang.classList.add('close');
            if (status_tamtru == true) {
                form_tamtru.classList.remove('close');
            }
            if (status_khaisinh == true) {
                form_khaisinh.classList.remove('close');
            }
            if (status_khaitu == true) {
                form_khaitu.classList.remove('close');
            }
            if (status_tamvang == true) {
                form_tamvang.classList.remove('close');
            }
        }

        folder_tamvang.forEach((item) => {
            item.addEventListener('click', () => {
                // dong list
                status_list_tamtru = false;
                status_list_khaisinh = false;
                status_list_khaitu = false;
                status_list_tamvang = false;
                show_list_form_employ(status_list_tamtru, status_list_khaisinh, status_list_khaitu, status_list_tamvang);
                // end
                status_tamtru = false;
                status_khaisinh = false;
                status_khaitu = false;
                status_tamvang = true;
                show_form_employ(status_tamtru, status_khaisinh, status_khaitu, status_tamvang);
            });
        });
        folder_khaitu.forEach((item) => {
            item.addEventListener('click', () => {
                // dong list
                status_list_tamtru = false;
                status_list_khaisinh = false;
                status_list_khaitu = false;
                status_list_tamvang = false;
                show_list_form_employ(status_list_tamtru, status_list_khaisinh, status_list_khaitu, status_list_tamvang);
                // end
                status_tamtru = false;
                status_khaisinh = false;
                status_khaitu = true;
                status_tamvang = false;
                show_form_employ(status_tamtru, status_khaisinh, status_khaitu, status_tamvang);
            });
        });
        folder_tamtru.forEach((item) => {
            item.addEventListener('click', () => {
                // dong list
                status_list_tamtru = false;
                status_list_khaisinh = false;
                status_list_khaitu = false;
                status_list_tamvang = false;
                show_list_form_employ(status_list_tamtru, status_list_khaisinh, status_list_khaitu, status_list_tamvang);
                // end
                status_tamtru = true;
                status_khaisinh = false;
                status_khaitu = false;
                status_tamvang = false;
                show_form_employ(status_tamtru, status_khaisinh, status_khaitu, status_tamvang);
            });
        });
        folder_khaisinh.forEach((item) => {
            item.addEventListener('click', () => {
                // dong list
                status_list_tamtru = false;
                status_list_khaisinh = false;
                status_list_khaitu = false;
                status_list_tamvang = false;
                show_list_form_employ(status_list_tamtru, status_list_khaisinh, status_list_khaitu, status_list_tamvang);
                // end
                status_tamtru = false;
                status_khaisinh = true;
                status_khaitu = false;
                status_tamvang = false;
                show_form_employ(status_tamtru, status_khaisinh, status_khaitu, status_tamvang);
            });
        });

    }
    catch (error) {
        console.log(error);
    }

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


    } catch (error) {
        console.log(error);
    }



    var inputFiletruoc = document.getElementById("mattruoc");
    var inputFilesau = document.getElementById("matsau");
    var fileNametruoc = document.getElementById("filename_truoc");
    var fileNamesau = document.getElementById("filename_sau");
    inputFiletruoc.addEventListener('change', function (event) {
        let fileName = event.target.files[0].name;
        fileNametruoc.textContent = fileName;
    })
    inputFilesau.addEventListener('change', function (event) {
        let fileName = event.target.files[0].name;
        fileNamesau.textContent = fileName;
    })
    //an hien thong bao
    let chuongthongbao = document.getElementById("user_announce_icon");
    console.log("hihi")
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



    // lam combobox ngay thang nam. năm nhuận %4,%100,%400

    try {
        const today = new Date();
        const currentYear = today.getFullYear();
        //gan nam vao combobox
        infoYear = document.querySelectorAll('.info_year');
        for (let i = currentYear; i >= 1900; i--) {
            infoYear[0].innerHTML += `<option value="${i}">${i}</option`;
        }
        //gan thang vao combobox
        infoMonth = document.querySelectorAll('.info_month');
        for (let i = 1; i <= 12; i++) {
            infoMonth[0].innerHTML += `<option value="${i}">${i}</option`;
        }
        //gan ngay vao combobox
        // Hàm để kiểm tra xem một năm có phải là năm nhuận không
        function isLeapYear(year) {
            return (year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0);
        }

        // Hàm để tạo danh sách các ngày dựa trên tháng và năm được chọn
        function populateDays() {
            infoDay = document.querySelectorAll('.info_day');
            infoDay[0].innerHTML = "";
            var selectedMonth = document.querySelectorAll('.info_month')[0].value;
            var selectedYear = document.querySelectorAll('.info_year')[0].value;
            var daysInMonth;

            if (selectedMonth == 2) {
                daysInMonth = isLeapYear(selectedYear) ? 29 : 28;
            } else if ([4, 6, 9, 11].includes(parseInt(selectedMonth))) {
                daysInMonth = 30;
            } else {
                daysInMonth = 31;
            }

            for (var i = 1; i <= daysInMonth; i++) {
                infoDay[0].innerHTML += `<option value="${i}">${i}</option`;
            }
        }
        // Gọi hàm populateDays khi thay đổi tháng hoặc năm
        document.querySelectorAll('.info_month')[0].addEventListener("change", populateDays);
        document.querySelectorAll('.info_year')[0].addEventListener("change", populateDays);
    }
    catch (error) {
        console.log(error);
    }
    try {
        const today = new Date();
        const currentYear = today.getFullYear();
        //gan nam vao combobox
        infoYear = document.querySelectorAll('.info_year');
        for (let i = currentYear; i >= 1900; i--) {
            infoYear[1].innerHTML += `<option value="${i}">${i}</option`;
        }
        //gan thang vao combobox
        infoMonth = document.querySelectorAll('.info_month');
        for (let i = 1; i <= 12; i++) {
            infoMonth[1].innerHTML += `<option value="${i}">${i}</option`;
        }
        //gan ngay vao combobox
        // Hàm để kiểm tra xem một năm có phải là năm nhuận không
        function isLeapYear(year) {
            return (year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0);
        }

        // Hàm để tạo danh sách các ngày dựa trên tháng và năm được chọn
        function populateDays() {
            infoDay = document.querySelectorAll('.info_day');
            infoDay[1].innerHTML = "";
            var selectedMonth = document.querySelectorAll('.info_month')[1].value;
            var selectedYear = document.querySelectorAll('.info_year')[1].value;
            var daysInMonth;

            if (selectedMonth == 2) {
                daysInMonth = isLeapYear(selectedYear) ? 29 : 28;
            } else if ([4, 6, 9, 11].includes(parseInt(selectedMonth))) {
                daysInMonth = 30;
            } else {
                daysInMonth = 31;
            }

            for (var i = 1; i <= daysInMonth; i++) {
                infoDay[1].innerHTML += `<option value="${i}">${i}</option`;
            }
        }
        // Gọi hàm populateDays khi thay đổi tháng hoặc năm
        document.querySelectorAll('.info_month')[1].addEventListener("change", populateDays);
        document.querySelectorAll('.info_year')[1].addEventListener("change", populateDays);
    }
    catch (error) {
        console.log(error);
    }

    try {
        const today = new Date();
        const currentYear = today.getFullYear();
        //gan nam vao combobox
        infoYear = document.querySelectorAll('.info_year');
        for (let i = currentYear; i >= 1900; i--) {
            infoYear[2].innerHTML += `<option value="${i}">${i}</option`;
        }
        //gan thang vao combobox
        infoMonth = document.querySelectorAll('.info_month');
        for (let i = 1; i <= 12; i++) {
            infoMonth[2].innerHTML += `<option value="${i}">${i}</option`;
        }
        //gan ngay vao combobox
        // Hàm để kiểm tra xem một năm có phải là năm nhuận không
        function isLeapYear(year) {
            return (year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0);
        }

        // Hàm để tạo danh sách các ngày dựa trên tháng và năm được chọn
        function populateDays() {
            infoDay = document.querySelectorAll('.info_day');
            infoDay[2].innerHTML = "";
            var selectedMonth = document.querySelectorAll('.info_month')[2].value;
            var selectedYear = document.querySelectorAll('.info_year')[2].value;
            var daysInMonth;

            if (selectedMonth == 2) {
                daysInMonth = isLeapYear(selectedYear) ? 29 : 28;
            } else if ([4, 6, 9, 11].includes(parseInt(selectedMonth))) {
                daysInMonth = 30;
            } else {
                daysInMonth = 31;
            }

            for (var i = 1; i <= daysInMonth; i++) {
                infoDay[2].innerHTML += `<option value="${i}">${i}</option`;
            }
        }
        // Gọi hàm populateDays khi thay đổi tháng hoặc năm
        document.querySelectorAll('.info_month')[2].addEventListener("change", populateDays);
        document.querySelectorAll('.info_year')[2].addEventListener("change", populateDays);
    }
    catch (error) {
        console.log(error);
    }


    try {
        const today = new Date();
        const currentYear = today.getFullYear();
        //gan nam vao combobox
        infoYear = document.querySelectorAll('.info_year');
        for (let i = currentYear; i >= 1900; i--) {
            infoYear[3].innerHTML += `<option value="${i}">${i}</option`;
        }
        //gan thang vao combobox
        infoMonth = document.querySelectorAll('.info_month');
        for (let i = 1; i <= 12; i++) {
            infoMonth[3].innerHTML += `<option value="${i}">${i}</option`;
        }
        //gan ngay vao combobox
        // Hàm để kiểm tra xem một năm có phải là năm nhuận không
        function isLeapYear(year) {
            return (year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0);
        }

        // Hàm để tạo danh sách các ngày dựa trên tháng và năm được chọn
        function populateDays() {
            infoDay = document.querySelectorAll('.info_day');
            infoDay[3].innerHTML = "";
            var selectedMonth = document.querySelectorAll('.info_month')[3].value;
            var selectedYear = document.querySelectorAll('.info_year')[3].value;
            var daysInMonth;

            if (selectedMonth == 2) {
                daysInMonth = isLeapYear(selectedYear) ? 29 : 28;
            } else if ([4, 6, 9, 11].includes(parseInt(selectedMonth))) {
                daysInMonth = 30;
            } else {
                daysInMonth = 31;
            }

            for (var i = 1; i <= daysInMonth; i++) {
                infoDay[3].innerHTML += `<option value="${i}">${i}</option`;
            }
        }
        // Gọi hàm populateDays khi thay đổi tháng hoặc năm
        document.querySelectorAll('.info_month')[3].addEventListener("change", populateDays);
        document.querySelectorAll('.info_year')[3].addEventListener("change", populateDays);
    }
    catch (error) {
        console.log(error);
    }

}