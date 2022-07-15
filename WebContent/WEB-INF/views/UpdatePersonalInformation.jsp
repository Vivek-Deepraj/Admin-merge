<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- <script>
function addContactRow(tableID) {

var table = document.getElementById(tableID);
var rowCount = table.rows.length;
index = rowCount;
var row = table.insertRow(rowCount);
var colCount = table.rows[0].cells.length;
for ( var i = 0; i < colCount; i++) {
var newcell = row.insertCell(i);
if(i!=0)
newcell.innerHTML = table.rows[0].cells[i].innerHTML;
if(i==0)
{
if(tableID=="dataTable")
newcell.innerHTML='<div class="input-group"><div class="input-group-prepend"><span class="input-group-text"><i class="la la-location-arrow"></i></span></div><input type="text" class="form-control" name="address[]" id="address" value="" placeholder="Address" aria-describedby="basic-addon1"><input type="text" class="form-control" name="city[]" id="city" value="" placeholder="City" aria-describedby="basic-addon1"><input type="text" class="form-control" name="state[]" id="state" value="" placeholder="State" aria-describedby="basic-addon1"><input type="text" class="form-control" name="country[]" id="country" value="" placeholder="Country" aria-describedby="basic-addon1"><input type="text" class="form-control" name="pincode[]" id="pincode" value="" placeholder="Pin Code" aria-describedby="basic-addon1"><Select name="type[]" id="type" class="form-control" aria-describedby="basic-addon1" ><option value="permanent_address">Permanent Address</option><option value="communication_address">Communication Address</option><option value="office_address">Office Address</option></Select><input name="input" type="button" class="btn btn-success" value="+" onClick="addContactRow('+"'dataTable'"+')" /><input name="input" type="button" class="btn btn-danger" value="-" onClick="deleteContactRow('+"'dataTable'"+',this)"/></div>';
else
newcell.innerHTML='<div class="input-group"><div class="input-group-prepend"><span class="input-group-text"><i class="la la-phone"></i></span></div><input type="text" class="form-control" name="contactno[]" id="contactno" value="" placeholder="Phone" aria-describedby="basic-addon1"><Select name="typeC[]" id="typeC" class="form-control" aria-describedby="basic-addon1" ><option value="primary_phone">Primary Phone</option><option value="secondary_phone">Seconday Phone</option><option value="mob_no">Mob No</option></Select><input name="input" type="button" class="btn btn-success" value="+" onClick="addContactRow('+"'dataTableC'"+')" /><input name="input" type="button" class="btn btn-danger" value="-" onClick="deleteContactRow('+"'dataTableC'"+',this)"/></div>';
}
}

}
function deleteContactRow(tableID,row) {
var table = document.getElementById(tableID);
var rowCount = table.rows.length;
if (rowCount > 1) {
var i = row.parentNode.parentNode.rowIndex;
document.getElementById(tableID).deleteRow(i);
}

}
</script> -->
<script>
    function submitForm() {

        $.validator.addMethod("mytst", function (value, element) {
            var flag = true;
            //alert(element.id+" || "+element.name)
            $("[name^=" + element.id + "]").each(function (i, j) {
                // $(this).parent("").find('label.error').remove();
                //  $(this).focus();
                if ($.trim($(this).val()) == '') {
                    flag = false;
                    //$(this).focus();
                    //$(this).click();
                    $(this).addClass('is-invalid');
                    $(this).addClass('your-class');
                    //alert($(this).val())
                    //$(this).attr('aria-describedby', '');
                    //$(this).next().append('<label  id="id_ct'+i+'-error" class="error">Enter '+$(this).attr('placeholder')+'</label>');
                } else {
                    //alert($(this).val()+' notempty')
                    $(this).removeClass('is-invalid');
                    $(this).removeClass('your-class');
                    //$(this).removeAttr('aria-describedby');
                }

                if ($(this).prop('disabled')) {
                    //alert($(this).val())
                    $(this).removeClass('is-invalid');
                    $(this).removeClass('your-class');
                    //$(this).removeAttr('aria-describedby');
                    flag = true;
                }
            });
            $("span.my-error-class").remove();
            return flag;
        }, "");

        /* $.validator.addMethod("profilePic", function (value, element) {
            var flag = true;
            alert(element.id+" || "+element.name)
          $("[name^="+element.id+"]").each(function (i, j) {
                           alert($.trim($(this).val()))
                            if ($.trim($(this).val()) == '') {
                                flag = false;
                                $(this).addClass('is-invalid');
                                $(this).addClass('your-class');
                            }
                            else
                            {
                                $(this).removeClass('is-invalid');
                                $(this).removeClass('your-class');
                            }

                            if($(this).prop('disabled'))
                            {
                                $(this).removeClass('is-invalid');
                                $(this).removeClass('your-class');
                                flag = true;
                            }
                        });
                          $("span.my-error-class").remove();
                        return flag;
        }, ""); */

        var validator = $("#myForme").validate({
            rules: {
                /*  profilepicture: {
                     profilePic:true
                }, */
                name: {
                    mytst: true
                },
                email: {
                    mytst: true
                },
                gender: {
                    mytst: true
                },
                maritalstatus: {
                    mytst: true
                },
                dob: {
                    mytst: true
                },
                nationality: {
                    mytst: true
                },
                "type[]": {
                    mytst: true
                },
                "address[]": {
                    mytst: true
                },
                "city[]": {
                    mytst: true
                },
                "state[]": {
                    mytst: true
                },
                "country[]": {
                    mytst: true
                },
                "pincode[]": {
                    mytst: true
                },
                "phone1": {
                    mytst: true
                },
                "phone2": {
                    mytst: true
                },
                "contactno": {
                    mytst: true
                }
            },
            errorPlacement: function (error, element) {
                return true;
            }/* ,
	     errorElement: "span" ,  
	     errorClass: "my-error-class",
	     messages: {	    	          
	    	 
	     } */
        });
        if (validator.form()) {

            //	 alert('validated...')
            //$('#userUpdate').prop('disabled',true);
            var formData = new FormData($('#myForme')[0]);
            jQuery.each(jQuery('#profilepicture')[0].files, function (i, file) {
                formData.append('profilepicture', file);
            });
            for (var pair of formData.entries()) {
                console.log(pair[0] + ', ' + pair[1]);
                console.log(typeof pair[1]);
            }
            // Ajax call
            var ajaxReq = $.ajax({
                url: 'updateProfileInfo',
                type: 'POST',
                //method: 'POST',
                enctype: 'multipart/form-data',
                data: formData,
                cache: false,
                contentType: false,
                //contentType : "multipart/form-data",
                processData: false
            });

            // Called on success
            ajaxReq.done(function (msg) {
                var alert = $('<div class="kt-alert kt-alert--outline alert alert-success alert-dismissible" role="alert">' +
                    '<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>' +
                    '	<span></span></div>');
                $('form#myForme').find('.alert').remove();
                alert.prependTo($('form#myForme'));
                alert.find('span').html("Candidate Details Successfully updated.");
            });

            // Called on failure
            ajaxReq.fail(function (jqXHR) {
                var alert = $('<div class="kt-alert kt-alert--outline alert alert-danger alert-dismissible" role="alert">' +
                    '<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>' +
                    '	<span></span></div>');
                $('form#myForme').find('.alert').remove();
                alert.prependTo($('form#myForme'));
                alert.find('span').html(jqXHR.responseText + '(' + jqXHR.status +
                    ' - ' + jqXHR.statusText + ')');
            });

        }
        return false;
    }
</script>

<!-- <script>
$(document).ready(
function(){
var dropdowns = [ ['#genderA', 'Gender'], ['#genderB', 'Genderr'], ['#maritalstatusS', 'Marital Status'] ];
for (var dd = 0; dd < dropdowns.length; dd++)
{
callFunc(dropdowns[dd][0], dropdowns[dd][1]);
}
});

function callFunc(dropId, dropVal){
$.getJSON('getMasterData_type.html',{
type: dropVal,
ajax: 'true',
async: 'false'
}, function(data){
$(dropId).html('');
$(dropId).append('<option value="">---Select---</option>');
for(var iii = 0; iii<data.length; iii++)
{
$(dropId).append('<option value="'+data[iii].code+'">'+data[iii].label+'</option>');
}
});
}
</script> -->
<script>
    $(document).ready(
        function () {
            var dropdowns = [['#gender', 'Gender'], ['#maritalstatus', 'Marital Status']];
            for (var dd = 0; dd < dropdowns.length; dd++) {
                callFunc(dropdowns[dd][0], dropdowns[dd][1]);
            }
        });

    function callFunc(dropId, dropVal) {
        $.getJSON('getMasterData_type', {
            type: dropVal,
            ajax: 'true',
            async: 'false'
        }, function (data) {
            $(dropId).html('');
            $(dropId).append('<option value="">---Select---</option>');
            for (var iii = 0; iii < data.length; iii++) {
                $(dropId).append('<option value="' + data[iii].code + '">' + data[iii].label + '</option>');
            }
        });
    }
</script>
<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--ver kt-grid--stretch">
    <div class="kt-container kt-body  kt-grid kt-grid--ver" id="kt_body">
        <div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">
            <div class="kt-subheader   kt-grid__item" id="kt_subheader">
                <div class="kt-subheader__main">
                    <h3 class="kt-subheader__title">Candidate</h3>
                    <div class="kt-subheader__breadcrumbs">
                        <a href="#" class="kt-subheader__breadcrumbs-home"><i class="flaticon2-shelter"></i></a>
                        <span class="kt-subheader__breadcrumbs-separator"></span>
                        <a href="" class="kt-subheader__breadcrumbs-link">
                            Candidate </a>
                        <span class="kt-subheader__breadcrumbs-separator"></span>
                        <a href="" class="kt-subheader__breadcrumbs-link">
                            Update Personal Information </a>
                    </div>
                </div>
                <div class="kt-subheader__toolbar">
                    <div class="kt-subheader__wrapper">

                    </div>
                </div>
            </div>
            <div class="kt-content kt-grid__item kt-grid__item--fluid">
                <div class="row">
                    <div class="col-xl-6">
                        <div class="kt-portlet kt-portlet--height-fluid">
                            <div class="kt-portlet__head">
                                <div class="kt-portlet__head-label">
                                    <h3 class="kt-portlet__head-title">
                                        Personal Information <small>update your personal informaiton</small>
                                    </h3>
                                </div>
                                <div class="kt-portlet__head-toolbar">

                                </div>
                            </div>
                            <div class="kt-portlet__body kt-portlet__body--fluid">
                                <form class="kt-form kt-form--label-right" id="myForme" action=""
                                      enctype="multipart/form-data">
                                    <div class="kt-portlet__body">
                                        <div class="kt-section kt-section--first">
                                            <div class="kt-section__body">
                                                <div class="row">
                                                    <label class="col-xl-3"></label>
                                                    <div class="col-lg-9 col-xl-6">
                                                        <h3 class="kt-section__title kt-section__title-sm">Candidate
                                                            Info:</h3>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-xl-3 col-lg-3 col-form-label">Profile
                                                        Picture</label>
                                                    <div class="col-lg-9 col-xl-6">
                                                        <div class="kt-avatar kt-avatar--outline" id="kt_user_avatarr">
                                                            <div class="kt-avatar__holder"
                                                                 style="background-image: url(${imageFile })"></div>
                                                            <label class="kt-avatar__upload" data-toggle="kt-tooltip"
                                                                   title=""
                                                                   data-original-title="Change Profile Picture">
                                                                <i class="fa fa-pen"></i>
                                                                <input type="file" name="profilepicture"
                                                                       id="profilepicture">
                                                                <!-- accept=".png, .jpg, .jpeg" -->
                                                            </label>
                                                            <span class="kt-avatar__cancel" data-toggle="kt-tooltip"
                                                                  title="" data-original-title="Cancel Profile Picture">
					                                                    <i class="fa fa-times"></i>
					                                                </span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-lg-2 col-form-label">Candidate Name</label>
                                                    <div class="col-lg-4">
                                                        <div class="input-group">
                                                            <div class="input-group-prepend"><span
                                                                    class="input-group-text"><i class="la la-user"></i></span>
                                                            </div>
                                                            <input type="text" class="form-control"
                                                                   value="${personalinfo.name}" name="name" id="name"
                                                                   placeholder="Candidate Name"
                                                                   aria-describedby="basic-addon1">
                                                        </div>
                                                    </div>
                                                    <label class="col-lg-2 col-form-label">Email Address</label>
                                                    <div class="col-lg-4">
                                                        <div class="input-group">
                                                            <div class="input-group-prepend"><span
                                                                    class="input-group-text"><i
                                                                    class="la la-at"></i></span></div>
                                                            <input type="text" class="form-control"
                                                                   value="${personalinfo.email}" name="email" id="email"
                                                                   placeholder="Email Address"
                                                                   aria-describedby="basic-addon1">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-lg-2 col-form-label">Gender</label>
                                                    <div class="col-lg-4">
                                                        <div class="input-group">
                                                            <div class="input-group-prepend"><span
                                                                    class="input-group-text"><i class="la la-group"></i></span>
                                                            </div>
                                                            <Select name="gender" id="gender" class="form-control"
                                                                    aria-describedby="basic-addon1">

                                                            </Select>
                                                        </div>
                                                    </div>
                                                    <label class="col-lg-2 col-form-label">Marital Status</label>
                                                    <div class="col-lg-4">
                                                        <div class="input-group">
                                                            <div class="input-group-prepend"><span
                                                                    class="input-group-text"><i
                                                                    class="la la-medium"></i></span></div>
                                                            <Select name="maritalstatus" id="maritalstatus"
                                                                    class="form-control"
                                                                    aria-describedby="basic-addon1">

                                                            </Select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-lg-2 col-form-label">Date Of Birth</label>
                                                    <div class="col-lg-4">
                                                        <div class="input-group">
                                                            <div class="input-group-prepend"><span
                                                                    class="input-group-text"><i
                                                                    class="la la-calendar"></i></span></div>
                                                            <input type="text" class="form-control kt_datepicker_4_4"
                                                                   value="${personalinfo.dob}" name="dob" id="dob"
                                                                   placeholder="Date Of Birth"
                                                                   aria-describedby="basic-addon1">
                                                        </div>
                                                    </div>
                                                    <label class="col-lg-2 col-form-label">Nationality</label>
                                                    <div class="col-lg-4">
                                                        <div class="input-group">
                                                            <div class="input-group-prepend"><span
                                                                    class="input-group-text"><i
                                                                    class="la la-flag-checkered"></i></span></div>
                                                            <input type="text" class="form-control"
                                                                   value="${personalinfo.nationality}"
                                                                   name="nationality" id="nationality"
                                                                   placeholder="Nationality"
                                                                   aria-describedby="basic-addon1">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <label class="col-xl-3"></label>
                                                    <div class="col-lg-9 col-xl-6">
                                                        <h3 class="kt-section__title kt-section__title-sm">Permanent
                                                            Address:</h3>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <div class="col-lg-12 col-xl-6">
                                                        <table id="dataTable">
                                                            <tr>
                                                                <td>
                                                                    <div class="input-group">
                                                                        <div class="input-group-prepend"><span
                                                                                class="input-group-text">Address</span>
                                                                        </div>
                                                                        <input type="text" class="form-control"
                                                                               name="address[]" id="address"
                                                                               value="${perm_addressinfo.address}"
                                                                               placeholder="Permanent Address"
                                                                               aria-describedby="basic-addon1">
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <div class="input-group">
                                                                        <div class="input-group-prepend"><span
                                                                                class="input-group-text">City</span>
                                                                        </div>
                                                                        <input type="text" class="form-control"
                                                                               name="city[]" id="city"
                                                                               value="${perm_addressinfo.city}"
                                                                               placeholder="City"
                                                                               aria-describedby="basic-addon1">
                                                                        <div class="input-group-prepend"><span
                                                                                class="input-group-text">State</span>
                                                                        </div>
                                                                        <input type="text" class="form-control"
                                                                               name="state[]" id="state"
                                                                               value="${perm_addressinfo.state}"
                                                                               placeholder="State"
                                                                               aria-describedby="basic-addon1">
                                                                        <div class="input-group-prepend"><span
                                                                                class="input-group-text">Country</span>
                                                                        </div>
                                                                        <input type="text" class="form-control"
                                                                               name="country[]" id="country"
                                                                               value="${perm_addressinfo.country}"
                                                                               placeholder="Country"
                                                                               aria-describedby="basic-addon1">
                                                                        <div class="input-group-prepend"><span
                                                                                class="input-group-text">Pin Code</span>
                                                                        </div>
                                                                        <input type="text" class="form-control"
                                                                               name="pincode[]" id="pincode"
                                                                               value="${perm_addressinfo.pincode}"
                                                                               placeholder="Pin Code"
                                                                               aria-describedby="basic-addon1">
                                                                        <input type="hidden" class="form-control"
                                                                               name="type[]" id="type"
                                                                               value="permanent_address"
                                                                               placeholder="Pin Code"
                                                                               aria-describedby="basic-addon1">
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <label class="col-xl-3"></label>
                                                    <div class="col-lg-9 col-xl-6">
                                                        <h3 class="kt-section__title kt-section__title-sm">Communication
                                                            Address:</h3>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <div class="col-lg-12 col-xl-6">
                                                        <table id="dataTable">
                                                            <tr>
                                                                <td>
                                                                    <div class="input-group">
                                                                        <div class="input-group-prepend"><span
                                                                                class="input-group-text">Address</span>
                                                                        </div>
                                                                        <input type="text" class="form-control"
                                                                               name="address[]" id="address"
                                                                               value="${comm_addressinfo.address}"
                                                                               placeholder="Communication Address"
                                                                               aria-describedby="basic-addon1">
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <div class="input-group">
                                                                        <div class="input-group-prepend"><span
                                                                                class="input-group-text">City</span>
                                                                        </div>
                                                                        <input type="text" class="form-control"
                                                                               name="city[]" id="city"
                                                                               value="${comm_addressinfo.city}"
                                                                               placeholder="City"
                                                                               aria-describedby="basic-addon1">
                                                                        <div class="input-group-prepend"><span
                                                                                class="input-group-text">State</span>
                                                                        </div>
                                                                        <input type="text" class="form-control"
                                                                               name="state[]" id="state"
                                                                               value="${comm_addressinfo.state}"
                                                                               placeholder="State"
                                                                               aria-describedby="basic-addon1">
                                                                        <div class="input-group-prepend"><span
                                                                                class="input-group-text">Country</span>
                                                                        </div>
                                                                        <input type="text" class="form-control"
                                                                               name="country[]" id="country"
                                                                               value="${comm_addressinfo.country}"
                                                                               placeholder="Country"
                                                                               aria-describedby="basic-addon1">
                                                                        <div class="input-group-prepend"><span
                                                                                class="input-group-text">Pin Code</span>
                                                                        </div>
                                                                        <input type="text" class="form-control"
                                                                               name="pincode[]" id="pincode"
                                                                               value="${comm_addressinfo.pincode}"
                                                                               placeholder="Pin Code"
                                                                               aria-describedby="basic-addon1">
                                                                        <input type="hidden" class="form-control"
                                                                               name="type[]" id="type"
                                                                               value="communication_address"
                                                                               placeholder="Pin Code"
                                                                               aria-describedby="basic-addon1">
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <label class="col-xl-3"></label>
                                                    <div class="col-lg-9 col-xl-6">
                                                        <h3 class="kt-section__title kt-section__title-sm">Contact
                                                            Info:</h3>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <div class="col-lg-9 col-xl-6">
                                                        <table id="dataTableC">
                                                            <tr>
                                                                <td>
                                                                    <div class="input-group">
                                                                        <div class="input-group-prepend"><span
                                                                                class="input-group-text">Phone I</span>
                                                                        </div>
                                                                        <input type="text" class="form-control"
                                                                               name="phone1" id="phone1"
                                                                               value="${contactsinfo.phone1}"
                                                                               placeholder="Phone I"
                                                                               aria-describedby="basic-addon1">
                                                                        <div class="input-group-prepend"><span
                                                                                class="input-group-text">Phone II</span>
                                                                        </div>
                                                                        <input type="text" class="form-control"
                                                                               name="phone2" id="phone2"
                                                                               value="${contactsinfo.phone2}"
                                                                               placeholder="Phone II"
                                                                               aria-describedby="basic-addon1">
                                                                        <div class="input-group-prepend"><span
                                                                                class="input-group-text">Mobile No</span>
                                                                        </div>
                                                                        <input type="text" class="form-control"
                                                                               name="contactno" id="contactno"
                                                                               value="${contactsinfo.contactno}"
                                                                               placeholder="Contact No"
                                                                               aria-describedby="basic-addon1">
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <!-- <div class="form-group row">
                                                    <label class="col-xl-3 col-lg-3 col-form-label">Gender</label>
                                                    <div class="col-lg-9 col-xl-6">
                                                        <div class="input-group">
                                                            <div class="input-group-prepend"><span class="input-group-text"><i class="la la-group"></i></span></div>
                                                            <Select name="genderA" id="genderA" class="form-control" aria-describedby="basic-addon1" >

                                                            </Select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-xl-3 col-lg-3 col-form-label">Gender</label>
                                                    <div class="col-lg-9 col-xl-6">
                                                        <div class="input-group">
                                                            <div class="input-group-prepend"><span class="input-group-text"><i class="la la-group"></i></span></div>
                                                            <Select name="genderB" id="genderB" class="form-control" aria-describedby="basic-addon1" >

                                                            </Select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-xl-3 col-lg-3 col-form-label">Marital Status</label>
                                                    <div class="col-lg-9 col-xl-6">
                                                        <div class="input-group">
                                                            <div class="input-group-prepend"><span class="input-group-text"><i class="la la-group"></i></span></div>
                                                            <Select name="maritalstatusS" id="maritalstatusS" class="form-control" aria-describedby="basic-addon1" >

                                                            </Select>
                                                        </div>
                                                    </div>
                                                </div> -->
                                            </div>
                                        </div>
                                    </div>
                                    <div class="kt-portlet__foot">
                                        <div class="kt-form__actions">
                                            <div class="row">
                                                <div class="col-lg-3 col-xl-3">
                                                </div>
                                                <div class="col-lg-9 col-xl-9">
                                                    <button type="button" onclick="submitForm()"
                                                            class="btn btn-success">Submit
                                                    </button>&nbsp;
                                                    <!-- <button type="reset" class="btn btn-secondary">Cancel</button> -->
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    setTimeout(function () {
        $('#gender').val('${personalinfo.gender}');
        $('#maritalstatus').val('${personalinfo.maritalstatus}');
    }, 1000);
    //document.getElementById("type").value='<c:out value="${details}"/>'
</script>