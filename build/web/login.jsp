<%@include file="head.html"%>

<center>
  <div class="col-md-10">
    <div class="content-box-2 agents-contact">
		<div class="heading">
		  <h5>Contact jhone doe</h5>
		</div>
		<form class="form-content pad-top-small" data-parsley-validate>
		  <div class="row">
			 <div class="col-md-6 form-group-1">
				<input type="text" class="form-control input-lg" placeholder="Name" required data-parsley-required-message="Please insert your name" name="name">
			 </div>
			 <div class="col-md-6 form-group-1">
				<input type="text" class="form-control input-lg" placeholder="E-mail ID" required data-parsley-required-message="Please insert your Email" name="email">
			 </div>
		  </div>
		  <div class="row">
			 <div class="col-md-6 form-group-1">
				<input type="text" class="form-control input-lg" placeholder="Contact no" required data-parsley-required-message="Please insert your contact no" data-parsley-min="10" name="contact">
			 </div>
			 <div class="col-md-6 form-group-1">
				<input type="text" class="form-control input-lg" placeholder="Enter your place" required name="location">
			 </div>
		  </div>
		  <div class="row">
			 <div class="form-group-1 col-md-12">
				<textarea class="form-control" placeholder="Enter your questions and queries" rows="3"  required data-parsley-minlength="20" data-parsley-minlength-message = "Come on! You need to enter at least a 20 character comment.."  data-parsley-validation-threshold="10" data-parsley-maxlength="100" name="message"></textarea>
			 </div>
		  </div>
		  <div class="row pad-top-small">
			 <div class="col-md-12">
				<button class="btn btn-primary btn-large pull-right">Submit</button>
			 </div>
			 <div class="text-success col-xs-12 hidden form-messges text-center">
				<p>We will responce as soon as possible.</p>
			 </div>
		  </div>

		</form>
		<div class="info-box-1">
		  <h5><span>Or call the agent</span></h5>
		  <p><span class="large-text-1"><span class="iconic-phone-square"></span>0987654321</span> (this is a sample number)</p>
		</div>
    </div>
  </div>
</center>