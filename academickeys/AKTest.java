package academickeys;

import java.net.*;
import java.io.*;
import javax.net.ssl.*;

public class AKTest {

	protected static String _username = "";
	protected static String _password = "";
	protected static String _endpoint = "";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
			+ "<API>"
			+ "	<Session>"
			+ "		<APIUsername><![CDATA[" + AKTest._username + "]]></APIUsername>"
			+ "		<APIKey><![CDATA[" + AKTest._password + "]]></APIKey>"
			+ "		<APITicket><![CDATA[ ]]></APITicket>"
			+ "	</Session>"
			+ "	<Request type=\"JobAdd\">"
			+ "		<Job>"
			+ "			<APIIdentifier><![CDATA[abcd1234]]></APIIdentifier>"
			+ "			<Discipline><![CDATA[Engineering]]></Discipline>"
			+ "			<Organization><![CDATA[SUNY Institute of Technology]]></Organization>"
			+ "			<OrganizationDescription><![CDATA[ ]]></OrganizationDescription>"
			+ "			<Department><![CDATA[Engineering, Science and Mathematics]]></Department>"
			+ "			<DepartmentDescription><![CDATA[ ]]></DepartmentDescription>"
			+ "			<Title><![CDATA[TEST JOB BY KEITH - YOU CAN DELETE ME]]></Title>"
			+ "			<Description><![CDATA[bla bla bla description goes here]]></Description>"
			+ "			<EOAAPolicy><![CDATA[ ]]></EOAAPolicy>"
			+ "			<Location>"
			+ "				<City><![CDATA[Utica]]></City>"
			+ "				<State><![CDATA[NY]]></State>"
			+ "				<Country><![CDATA[US]]></Country>"
			+ "			</Location>"
			+ "			<Contact>"
			+ "				<Organization><![CDATA[SUNY Institute of Technology]]></Organization>"
			+ "				<Department><![CDATA[Engineering, Science and Mathematics]]></Department>"
			+ "				<Name><![CDATA[Anthony F. Panebianco]]></Name>"
			+ "			</Contact>"
			+ "			<PositionStartDescription><![CDATA[October 30, 2012]]></PositionStartDescription>"
			+ "			<PositionDeadlineDescription><![CDATA[February 27, 2013]]></PositionDeadlineDescription>"
			+ "			<ApplyUrl><![CDATA[http://www.Click2Apply.net/zzwq4hy]]></ApplyUrl>"
			+ "	"						
			+ "	"
			+ "	"
			+ "			<!-- THIS IS THE ONLY SECTION THAT REQUIRES CHANGES FOR YOU, PLEASE READ THE COMMENTS BELOW -->"
			+ "	"						
			+ "	"
			+ "			<!-- IF THE PERSON HAS AN EXISTING CONTRACT/PACKAGE WITH US, SEND US THIS: -->"
			+ "			<!--<ContractRef>"
			+ "				<ContractID><![CDATA[25030]]></ContractID>"
			+ "				<PONumber><![CDATA[ ]]></PONumber>"
			+ "			</ContractRef>-->"
			+ "	"
			+ "			<!-- HOWEVER, IF THE PERSON *DOES NOT* HAVE AN EXISTING CONTRACT/PACKAGE WITH US, SEND US THIS INSTEAD: -->"
			+ "			<ContractRef>"
			+ "				<PostingOptionID>81</PostingOptionID>"
			+ "				<PONumber><![CDATA[ ]]></PONumber>"
			+ "			</ContractRef>"
			+ "	"						
			+ "	"						
			+ "	"	
			+ "			<FieldList>"
			+ "				<Field><![CDATA[Mechanical Engineering]]></Field>"
			+ "			</FieldList>"
			+ "			<CategoryList>"
			+ "				<Category><![CDATA[Associate Professor]]></Category>"
			+ "			</CategoryList>"
			+ "			<UpsellList>"
			+ "				<UpsellID><![CDATA[ ]]></UpsellID>"
			+ "			</UpsellList>"
			+ "			<TrackingUrl><![CDATA[https://rs.careerliaison.com/pixel/zzwq4hy]]></TrackingUrl>"
			+ "			<TrackingScript><![CDATA[ ]]></TrackingScript>"
			+ "			<ExpireDate><![CDATA[ ]]></ExpireDate>"
			+ "			<Notes><![CDATA[ ]]></Notes>"
			+ "		</Job>"
			+ "	</Request>"
			+ "</API>";
		
		String out = "";
		try {
			out = AKTest._doRequest(xml);
			System.out.println(out);
		}
		catch (Exception ex) {
			System.out.println("Something bad happened: " + ex.getMessage());
		}
		
	}

	protected static String _doRequest(String xml) throws Exception {
		String xmlOut = null;
		       
		try 
		{
			URL url = new URL(AKTest._endpoint);
			
			// Set up the HTTP connection
			URLConnection connection = null;
			if (AKTest._endpoint.toLowerCase().contains("https"))
			{
				connection = (HttpsURLConnection) url.openConnection();
			}
			else
			{
				connection = (HttpURLConnection) url.openConnection();
			}
			connection.setDoOutput(true);
			connection.setDoInput(true);
			
			connection.setRequestProperty("Content-Type", "text/xml");
			
			// Write the XML to the API endpoint
			PrintWriter out = new PrintWriter(connection.getOutputStream());
			out.println(xml);
			out.close();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine = "";
			xmlOut = "";
			StringBuffer strOut = new StringBuffer();
          
			// Read the XML response 
			while ((inputLine = in.readLine()) != null)
			{
				strOut.append(inputLine);
			}
			xmlOut = strOut.toString();

			in.close();
		}
		catch(ConnectException conEx)
		{
			System.out.println("Connection is unavailable. (ConnectException in SecureEnterpriseSocketSession class) " + conEx);
			throw new Exception(conEx.getMessage());
		}
		catch(MalformedURLException malformedURLEx)
		{
			System.out.println("Invalid URL. Cannot Connect. (MalformedURLException in SecureEnterpriseSocketSession class) " + malformedURLEx);
			throw new Exception(malformedURLEx.getMessage());
		}
		catch(IOException ioEx)
		{
			System.out.println("Invalid URL. Cannot Connect. (IOException in SecureEnterpriseSocketSession class) " + ioEx);
			throw new Exception(ioEx.getMessage());
		}
		
		return xmlOut;
	}
	
}
