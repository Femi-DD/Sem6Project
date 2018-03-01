$(document).ready(function(){
// use jQuery correctly with strict
    (function($) {
        "use strict";
        // your code
        
    /*----------------------------------------------------*/
    /*  Add Photo Gallery
    /*----------------------------------------------------*/
        $('#add_photo_gallery').fileinput({
            uploadUrl: "http://localhost:8000/images",
            browseLabel: "Add Photos",
            initialPreview: [                
                '<img src="images/initial-photos/1.jpg" class="file-preview-image" title="2014-11-01 11.22.26.jpg" alt="2014-11-01 11.22.26.jpg" style="width:auto;height:160px;">' +
                '<div class="file-thumbnail-footer">'+
                    '<div class="file-caption-name" title="2014-11-01 11.22.26.jpg" style="width: 130px;">2014-11-01 11.22.26.jpg</div>' +
                    '<div class="file-actions">' +
                        '<div class="file-footer-buttons">' +
                            '<button type="button" class="kv-file-upload btn btn-xs btn-default" title="Upload file">   <i class="glyphicon glyphicon-upload text-info"></i></button>' +
                            '<button type="button" class="kv-file-remove btn btn-xs btn-default" title="Remove file"><i class="glyphicon glyphicon-trash text-danger"></i></button>'+
                        '</div>'+
                        '<div class="file-upload-indicator" tabindex="-1" title="Not uploaded yet"><i class="glyphicon glyphicon-hand-down text-warning"></i></div>'+
                        '<div class="clearfix"></div>'+
                    '</div>'+
                '</div>', // preview img 1             
                '<img src="images/initial-photos/2.jpg" class="file-preview-image" title="2014-11-01 11.22.26.jpg" alt="2014-11-01 11.22.26.jpg" style="width:auto;height:160px;">' +
                '<div class="file-thumbnail-footer">'+
                    '<div class="file-caption-name" title="2014-11-01 11.22.26.jpg" style="width: 130px;">2014-11-01 11.22.26.jpg</div>' +
                    '<div class="file-actions">' +
                        '<div class="file-footer-buttons">' +
                            '<button type="button" class="kv-file-upload btn btn-xs btn-default" title="Upload file">   <i class="glyphicon glyphicon-upload text-info"></i></button>' +
                            '<button type="button" class="kv-file-remove btn btn-xs btn-default" title="Remove file"><i class="glyphicon glyphicon-trash text-danger"></i></button>'+
                        '</div>'+
                        '<div class="file-upload-indicator" tabindex="-1" title="Not uploaded yet"><i class="glyphicon glyphicon-hand-down text-warning"></i></div>'+
                        '<div class="clearfix"></div>'+
                    '</div>'+
                '</div>', // preview img 2           
                '<img src="images/initial-photos/3.jpg" class="file-preview-image" title="2014-11-01 11.22.26.jpg" alt="2014-11-01 11.22.26.jpg" style="width:auto;height:160px;">' +
                '<div class="file-thumbnail-footer">'+
                    '<div class="file-caption-name" title="2014-11-01 11.22.26.jpg" style="width: 130px;">2014-11-01 11.22.26.jpg</div>' +
                    '<div class="file-actions">' +
                        '<div class="file-footer-buttons">' +
                            '<button type="button" class="kv-file-upload btn btn-xs btn-default" title="Upload file">   <i class="glyphicon glyphicon-upload text-info"></i></button>' +
                            '<button type="button" class="kv-file-remove btn btn-xs btn-default" title="Remove file"><i class="glyphicon glyphicon-trash text-danger"></i></button>'+
                        '</div>'+
                        '<div class="file-upload-indicator" tabindex="-1" title="Not uploaded yet"><i class="glyphicon glyphicon-hand-down text-warning"></i></div>'+
                        '<div class="clearfix"></div>'+
                    '</div>'+
                '</div>', // preview img 3              
                '<img src="images/initial-photos/4.jpg" class="file-preview-image" title="2014-11-01 11.22.26.jpg" alt="2014-11-01 11.22.26.jpg" style="width:auto;height:160px;">' +
                '<div class="file-thumbnail-footer">'+
                    '<div class="file-caption-name" title="2014-11-01 11.22.26.jpg" style="width: 130px;">2014-11-01 11.22.26.jpg</div>' +
                    '<div class="file-actions">' +
                        '<div class="file-footer-buttons">' +
                            '<button type="button" class="kv-file-upload btn btn-xs btn-default" title="Upload file">   <i class="glyphicon glyphicon-upload text-info"></i></button>' +
                            '<button type="button" class="kv-file-remove btn btn-xs btn-default" title="Remove file"><i class="glyphicon glyphicon-trash text-danger"></i></button>'+
                        '</div>'+
                        '<div class="file-upload-indicator" tabindex="-1" title="Not uploaded yet"><i class="glyphicon glyphicon-hand-down text-warning"></i></div>'+
                        '<div class="clearfix"></div>'+
                    '</div>'+
                '</div>', // preview img 4             
                '<img src="images/initial-photos/5.jpg" class="file-preview-image" title="2014-11-01 11.22.26.jpg" alt="2014-11-01 11.22.26.jpg" style="width:auto;height:160px;">' +
                '<div class="file-thumbnail-footer">'+
                    '<div class="file-caption-name" title="2014-11-01 11.22.26.jpg" style="width: 130px;">2014-11-01 11.22.26.jpg</div>' +
                    '<div class="file-actions">' +
                        '<div class="file-footer-buttons">' +
                            '<button type="button" class="kv-file-upload btn btn-xs btn-default" title="Upload file">   <i class="glyphicon glyphicon-upload text-info"></i></button>' +
                            '<button type="button" class="kv-file-remove btn btn-xs btn-default" title="Remove file"><i class="glyphicon glyphicon-trash text-danger"></i></button>'+
                        '</div>'+
                        '<div class="file-upload-indicator" tabindex="-1" title="Not uploaded yet"><i class="glyphicon glyphicon-hand-down text-warning"></i></div>'+
                        '<div class="clearfix"></div>'+
                    '</div>'+
                '</div>', // preview img 5           
                '<img src="images/initial-photos/6.jpg" class="file-preview-image" title="2014-11-01 11.22.26.jpg" alt="2014-11-01 11.22.26.jpg" style="width:auto;height:160px;">' +
                '<div class="file-thumbnail-footer">'+
                    '<div class="file-caption-name" title="2014-11-01 11.22.26.jpg" style="width: 130px;">2014-11-01 11.22.26.jpg</div>' +
                    '<div class="file-actions">' +
                        '<div class="file-footer-buttons">' +
                            '<button type="button" class="kv-file-upload btn btn-xs btn-default" title="Upload file">   <i class="glyphicon glyphicon-upload text-info"></i></button>' +
                            '<button type="button" class="kv-file-remove btn btn-xs btn-default" title="Remove file"><i class="glyphicon glyphicon-trash text-danger"></i></button>'+
                        '</div>'+
                        '<div class="file-upload-indicator" tabindex="-1" title="Not uploaded yet"><i class="glyphicon glyphicon-hand-down text-warning"></i></div>'+
                        '<div class="clearfix"></div>'+
                    '</div>'+
                '</div>', // preview img 6              
                '<img src="images/initial-photos/7.jpg" class="file-preview-image" title="2014-11-01 11.22.26.jpg" alt="2014-11-01 11.22.26.jpg" style="width:auto;height:160px;">' +
                '<div class="file-thumbnail-footer">'+
                    '<div class="file-caption-name" title="2014-11-01 11.22.26.jpg" style="width: 130px;">2014-11-01 11.22.26.jpg</div>' +
                    '<div class="file-actions">' +
                        '<div class="file-footer-buttons">' +
                            '<button type="button" class="kv-file-upload btn btn-xs btn-default" title="Upload file">   <i class="glyphicon glyphicon-upload text-info"></i></button>' +
                            '<button type="button" class="kv-file-remove btn btn-xs btn-default" title="Remove file"><i class="glyphicon glyphicon-trash text-danger"></i></button>'+
                        '</div>'+
                        '<div class="file-upload-indicator" tabindex="-1" title="Not uploaded yet"><i class="glyphicon glyphicon-hand-down text-warning"></i></div>'+
                        '<div class="clearfix"></div>'+
                    '</div>'+
                '</div>', // preview img 7             
                '<img src="images/initial-photos/8.jpg" class="file-preview-image" title="2014-11-01 11.22.26.jpg" alt="2014-11-01 11.22.26.jpg" style="width:auto;height:160px;">' +
                '<div class="file-thumbnail-footer">'+
                    '<div class="file-caption-name" title="2014-11-01 11.22.26.jpg" style="width: 130px;">2014-11-01 11.22.26.jpg</div>' +
                    '<div class="file-actions">' +
                        '<div class="file-footer-buttons">' +
                            '<button type="button" class="kv-file-upload btn btn-xs btn-default" title="Upload file">   <i class="glyphicon glyphicon-upload text-info"></i></button>' +
                            '<button type="button" class="kv-file-remove btn btn-xs btn-default" title="Remove file"><i class="glyphicon glyphicon-trash text-danger"></i></button>'+
                        '</div>'+
                        '<div class="file-upload-indicator" tabindex="-1" title="Not uploaded yet"><i class="glyphicon glyphicon-hand-down text-warning"></i></div>'+
                        '<div class="clearfix"></div>'+
                    '</div>'+
                '</div>', // preview img 8 
            ]
        })
        
    })(jQuery)
})