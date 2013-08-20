jobs-api_java
=============

Java code examples for the AcademicKeys.com job posting API.

Notes about example_xml/job_add.xml
-----------------------------------

* In job_add.xml, please pay special attention to the [ContractRef] section. You can do ONE of TWO things here: 1. You can provide a ContractID value - this is for a university that has an unlimited posting package with us, or has a 10-job package or something with us. e.g. anything that's not just a one-off posting. OR 2. You can provide a PostingOptionID value - this is for one-off postings, and I will send you a valid list of options and prices. You can also fetch them using a PostingOptionSearch command (I will send an example of this). 

* In job_add.xml, please also note the [ContractRef] option [PONumber]. You should put your PO # here so we can invoice you later.

* In job_add.xml, there is a [TrackingUrl] tag. If you have a tracking pixel/image you use, send it to us here (e.g. http://your-domain.com/path/to/tracking/pixel.gif)

* If you have a unique tracking tag/string that must be embedded in the job description/on the job description page, specify that in the [TrackingTag] tag. 

* Please send *your job #* or other unique identifier for the job in the [APIIdentifier] tag.

* From a response to job_add.xml, you will get back a [JobID] tag from us. This is our unique JobID value. You should store this in your system.

* From a response to job_add.xml, you will get back a [Permalink] tag from us. This is a link to the job on our website that you can give to your client.