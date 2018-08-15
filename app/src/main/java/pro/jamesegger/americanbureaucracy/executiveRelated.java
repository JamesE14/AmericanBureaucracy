package pro.jamesegger.americanbureaucracy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class executiveRelated extends AppCompatActivity
{
	Intent executiveSelection;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.executive);
		executiveSelection = new Intent(executiveRelated.this, executiveSpecific.class);

	}

	protected void onStart()
	{
		super.onStart();


	}

	public void on_Click_Go_Executive_Specific_President(View view)
	{
		executiveSelection.putExtra("ExecutiveSpecific", "President");
		executiveRelated.this.startActivity(executiveSelection);
	}

	public void on_Click_Go_Executive_Specific_Vice(View view)
	{
		executiveSelection.putExtra("ExecutiveSpecific", "Vice");
		executiveRelated.this.startActivity(executiveSelection);
	}

	public void on_Click_Go_Executive_Specific_Cabinet(View view)
	{
		executiveSelection.putExtra("ExecutiveSpecific", "Cabinet");
		executiveRelated.this.startActivity(executiveSelection);
	}

	public void on_Click_Go_Executive_Specific_Level_Cabinet(View view)
	{
		executiveSelection.putExtra("ExecutiveSpecific", "Level");
		executiveRelated.this.startActivity(executiveSelection);
	}





}




/*
		RequestQueue queue = Volley.newRequestQueue(this);

		String url = "https://www.whitehouse.gov/the-trump-administration/the-cabinet/#8217";
		StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
				new Response.Listener<String>()
				{
					@Override
					public void onResponse(String response)
					{
						Matcher m1 = Pattern.compile("Vice President (.*)").matcher(response);
						if(m1.find())
						{
							vicePresident = m1.group(1);
							int indexOfCarrot = vicePresident.indexOf("<");
							vicePresident = vicePresident.substring(0,indexOfCarrot);


						}

						m1 = Pattern.compile("Administrator of the Small Business Administration (.*)").matcher(response);
						if(m1.find())
						{
							AdministratorSmallBusinessAdministration = m1.group(1);
							int indexOfCarrot = AdministratorSmallBusinessAdministration.indexOf("<");
							AdministratorSmallBusinessAdministration = AdministratorSmallBusinessAdministration.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Attorney General (.*)").matcher(response);
						if(m1.find())
						{
							AttorneyGeneral = m1.group(1);
							int indexOfCarrot = AttorneyGeneral.indexOf("<");
							AttorneyGeneral = AttorneyGeneral.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Director of National Intelligence (.*)").matcher(response);
						if(m1.find())
						{
							DirectorNationalIntelligence = m1.group(1);
							int indexOfCarrot = DirectorNationalIntelligence.indexOf("<");
							DirectorNationalIntelligence = DirectorNationalIntelligence.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Director of the Central Intelligence Agency (.*)").matcher(response);
						if(m1.find())
						{
							DirectorCentralIntelligenceAgency = m1.group(1);
							int indexOfCarrot = DirectorCentralIntelligenceAgency.indexOf("<");
							DirectorCentralIntelligenceAgency = DirectorCentralIntelligenceAgency.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Director of the Office of Management and Budget (.*)").matcher(response);
						if(m1.find())
						{
							DirectorOfficeManagementBudget = m1.group(1);
							int indexOfCarrot = DirectorOfficeManagementBudget.indexOf("<");
							DirectorOfficeManagementBudget = DirectorOfficeManagementBudget.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Representative of the United States to the United Nations (.*)").matcher(response);
						if(m1.find())
						{
							RepresentativeUnitedStatesUnitedNations = m1.group(1);
							int indexOfCarrot = RepresentativeUnitedStatesUnitedNations.indexOf("<");
							RepresentativeUnitedStatesUnitedNations = RepresentativeUnitedStatesUnitedNations.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of Agriculture (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryAgriculture = m1.group(1);
							int indexOfCarrot = SecretaryAgriculture.indexOf("<");
							SecretaryAgriculture = SecretaryAgriculture.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of Commerce (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryCommerce = m1.group(1);
							int indexOfCarrot = SecretaryCommerce.indexOf("<");
							SecretaryCommerce = SecretaryCommerce.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of Defense (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryDefense = m1.group(1);
							int indexOfCarrot = SecretaryDefense.indexOf("<");
							SecretaryDefense = SecretaryDefense.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of Education (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryEducation = m1.group(1);
							int indexOfCarrot = SecretaryEducation.indexOf("<");
							SecretaryEducation = SecretaryEducation.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of Energy (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryEnergy = m1.group(1);
							int indexOfCarrot = SecretaryEnergy.indexOf("<");
							SecretaryEnergy = SecretaryEnergy.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of Health (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryHealthHumanServices = m1.group(1);
							int indexOfCarrot = SecretaryHealthHumanServices.indexOf("<");
							SecretaryHealthHumanServices = SecretaryHealthHumanServices.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of Homeland Security (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryHomelandSecurity = m1.group(1);
							int indexOfCarrot = SecretaryHomelandSecurity.indexOf("<");
							SecretaryHomelandSecurity = SecretaryHomelandSecurity.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of Housing and Urban Development (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryHousingUrbanDevelopment = m1.group(1);
							int indexOfCarrot = SecretaryHousingUrbanDevelopment.indexOf("<");
							SecretaryHousingUrbanDevelopment = SecretaryHousingUrbanDevelopment.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of the Interior (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryInterior = m1.group(1);
							int indexOfCarrot = SecretaryInterior.indexOf("<");
							SecretaryInterior = SecretaryInterior.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of Labor (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryLabor = m1.group(1);
							int indexOfCarrot = SecretaryLabor.indexOf("<");
							SecretaryLabor = SecretaryLabor.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of State (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryState = m1.group(1);
							int indexOfCarrot = SecretaryState.indexOf("<");
							SecretaryState = SecretaryState.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of Transportation (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryTransportation = m1.group(1);
							int indexOfCarrot = SecretaryTransportation.indexOf("<");
							SecretaryTransportation = SecretaryTransportation.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of the Treasury (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryTreasury = m1.group(1);
							int indexOfCarrot = SecretaryTreasury.indexOf("<");
							SecretaryTreasury = SecretaryTreasury.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("Secretary of Veterans Affairs (.*)").matcher(response);
						if(m1.find())
						{
							SecretaryVeteransAffairs = m1.group(1);
							int indexOfCarrot = SecretaryVeteransAffairs.indexOf("<");
							SecretaryVeteransAffairs = SecretaryVeteransAffairs.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("U.S. Trade Representative (.*)").matcher(response);
						if(m1.find())
						{
							TradeRepresentative = m1.group(1);
							int indexOfCarrot = TradeRepresentative.indexOf("<");
							TradeRepresentative = TradeRepresentative.substring(0,indexOfCarrot);
						}

						m1 = Pattern.compile("White House Chief of Staff (.*)").matcher(response);
						if(m1.find())
						{
							WhiteHouseChiefStaff = m1.group(1);
							int indexOfCarrot = WhiteHouseChiefStaff.indexOf("<");
							WhiteHouseChiefStaff = WhiteHouseChiefStaff.substring(0,indexOfCarrot);
						}

						textTestDisplay.setText(vicePresident +" "+ AdministratorSmallBusinessAdministration +" "+ AttorneyGeneral
								+" "+DirectorNationalIntelligence+" "+DirectorCentralIntelligenceAgency+" "+DirectorOfficeManagementBudget+" "+RepresentativeUnitedStatesUnitedNations
								+" "+SecretaryAgriculture+" "+SecretaryCommerce+" "+SecretaryDefense+SecretaryEducation+" "+SecretaryEnergy
								+" "+SecretaryHealthHumanServices+" "+SecretaryHomelandSecurity+" "+SecretaryHousingUrbanDevelopment+" "+SecretaryInterior+" "+SecretaryLabor+" "+SecretaryState+" "+SecretaryTransportation
								+" "+SecretaryTreasury+" "+SecretaryVeteransAffairs+" "+TradeRepresentative+" "+WhiteHouseChiefStaff);


					}
				},
				new Response.ErrorListener()
				{
					@Override
					public void onErrorResponse(VolleyError error) {
						// handle error response
					}
				}
		);

		queue.add(stringRequest);
		*/
