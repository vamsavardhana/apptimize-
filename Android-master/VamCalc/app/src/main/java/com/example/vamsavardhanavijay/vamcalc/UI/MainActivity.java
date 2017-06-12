package com.example.vamsavardhanavijay.vamcalc.UI;

//Apptimizes libraries
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.apptimize.ApptimizeOptions;
import com.example.vamsavardhanavijay.vamcalc.R;
import com.example.vamsavardhanavijay.vamcalc.model.Model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.Date;

import com.apptimize.Apptimize;
import com.apptimize.ApptimizeExperiment;
import com.apptimize.ApptimizeTest;

public class MainActivity extends Activity {
    Model model, model1;
    EditText purchaseprice, downpayment, mortgageterm, interestrate, propertytax, propertyinsurance, zipcode;
    Button calculate1;
    Spinner spinner1, spinner2;
    String[] spinner1vars = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
            "November", "December"};
    String[] spinner2vars = {"2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015",
            "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"};
    int tmp;//total monthly payment
    int tpm;//total of payment for mortgage term
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //apptimize call
        //apptimize options call
        ApptimizeOptions a=new ApptimizeOptions();
        a.setDeveloperModeDisabled(false);
        a.setLogLevel(ApptimizeOptions.LogLevel.DEBUG);
        a.setThirdPartyEventExportingEnabled(true);
        a.setThirdPartyEventImportingEnabled(true);
        a.setExplicitEnablingRequired(false);
        a.setDeviceName("Vamsa");
        Apptimize.setup(this, "AcrnraUcgdPEeRJdnPdx6Jfx6fWUZNU");
        Apptimize.track("Event1");
        Apptimize.track("Event1", 100.00);

        purchaseprice = (EditText) findViewById(R.id.purchaseprice);
        downpayment = (EditText) findViewById(R.id.downpayment);
        mortgageterm = (EditText) findViewById(R.id.mortgageterm);
        interestrate = (EditText) findViewById(R.id.interestrate);
        propertytax = (EditText) findViewById(R.id.propertytax);
        propertyinsurance = (EditText) findViewById(R.id.propertyinsurance);
        zipcode = (EditText) findViewById(R.id.zipcode);
        calculate1 = (Button) findViewById(R.id.calculate1);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, spinner1vars);
        spinner1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, spinner2vars);
        spinner2.setAdapter(adapter2);
        String check1 = spinner1.getSelectedItem().toString();
        Log.i("check1", check1);
        String check2 = spinner2.getSelectedItem().toString();
        Log.i("check2", check2);
        Apptimize.track("Event1");
        Apptimize.track("Event1", 100.00);

        calculate1.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              int i=0;
                                              while(i<100)
                                              {
                                                  Apptimize.runTest("New Experiment", new ApptimizeTest() {
                                                      @Override
                                                      public void baseline() {
                                                          // Variant: original
                                                      }

                                                      @SuppressWarnings("unused")
                                                      public void variation1() {
                                                          // Variant: Variant B
                                                      }
                                                  });
                                                  i++;
                                              }

                                              Apptimize.track("Event1");
                                              Apptimize.track("Event1", 100.00);
                                              Log.i("check2_1", spinner1.getSelectedItem().toString());
                                              Log.i("check2_2", Model.selectedMonth);
                                              model.selectedMonth = spinner1.getSelectedItem().toString();
                                              Log.i("check3", model.selectedMonth);
                                              model.selectedYear = spinner2.getSelectedItem().toString();
                                              Log.i("check4", model.selectedYear);
                                              Log.e("check5", purchaseprice.getText().toString());

                                              try {
                                                  model.purchasePrice = Integer.parseInt(purchaseprice.getText().toString());
                                              } catch (NumberFormatException ae) {
                                                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                  builder.setMessage("Please enter the purchase price.");
                                                  AlertDialog alert = builder.create();
                                                  alert.show();
                                                  Log.i("ex", "exception handled");
                                              }
                                              Log.i("check6", downpayment.getText().toString());
                                              try {
                                                  model.downPayment = Integer.parseInt(downpayment.getText().toString());
                                              } catch (NumberFormatException be) {
                                                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                  builder.setMessage("Please enter the downpayment");
                                                  AlertDialog alert = builder.create();
                                                  alert.show();
                                                  Log.i("ex", "exception handled");
                                              }
                                              try {
                                                  model.mortgageTerm = Integer.parseInt(mortgageterm.getText().toString());
                                              } catch (NumberFormatException ce) {
                                                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                  builder.setMessage("Please enter the mortgage term");
                                                  AlertDialog alert = builder.create();
                                                  alert.show();
                                                  Log.i("ex", "exception handled");
                                              }
                                              try {
                                                  model.interestRate = Integer.parseInt(interestrate.getText().toString());
                                              } catch (NumberFormatException ce) {
                                                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                  builder.setMessage("Please enter the interest rate");
                                                  AlertDialog alert = builder.create();
                                                  alert.show();
                                                  Log.i("ex", "exception handled");
                                              }
//
                                              try {
                                                  model.propertyTax = Integer.parseInt(propertytax.getText().toString());
                                              } catch (NumberFormatException de) {
                                                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                  builder.setMessage("Please enter the property tax");
                                                  AlertDialog alert = builder.create();
                                                  alert.show();
                                                  Log.i("ex", "exception handled");
                                              }

                                              try {
                                                  model.propertyInsurance = Integer.parseInt(propertyinsurance.getText().toString());
                                              } catch (NumberFormatException ee) {
                                                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                  builder.setMessage("Please enter the property insurance");
                                                  AlertDialog alert = builder.create();
                                                  alert.show();
                                                  Log.i("ex", "exception handled");

                                              }
                                              try {
                                                  model.zipCode = Integer.parseInt(zipcode.getText().toString());
                                              } catch (NumberFormatException fe) {
                                                  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                  builder.setMessage("Please enter the zipcode");
                                                  AlertDialog alert = builder.create();
                                                  alert.show();
                                                  Log.i("ex", "exception handled");

                                              }

                                              Log.i("Hellochk", "\"" + model.zipCode + "\"");
                                              if (model.purchasePrice != 0 & model.interestRate != 0 & model.downPayment != 0 & model.zipCode != 0 & model.propertyInsurance != 0 & model.propertyTax != 0 & model.mortgageTerm != 0) {
                                                  Log.i("purchaseprice",model.purchasePrice+" ");
                                                  Intent newIntent = new Intent(MainActivity.this, SecondActivity.class).putExtra("modelobject", model);
                                                 startActivity(newIntent);
                                              }

                                              try {
                                                  File dir = Environment.getExternalStorageDirectory();
                                                  Log.i("dir", dir.toString());
                                                  FileWriter writer = new FileWriter(new File(dir, "VVIJAY.txt"));
                                                  Log.i("Filewrite", writer.toString());
                                                  FileOutputStream fileout = openFileOutput("mytextfile.txt", Context.MODE_PRIVATE);
                                                  OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                                                  Log.i("CHECKCEHCKEHCKJEK", "\"" + model1.purchasePrice + "\"");
                                                  if (model1.purchasePrice == 0) {
                                                      FileOutputStream fos;

                                                      try {
                                                          fos = new FileOutputStream("/sdcard/VVIJAY.txt", true);

                                                          FileWriter fWriter;

                                                          try {
                                                              fWriter = new FileWriter(fos.getFD());
                                                              Date date = new Date();

                                                              fWriter.write("A purchaseprice not found exception is logged" + date.toString() + "\n");
                                                              fWriter.close();
                                                          } catch (Exception e) {
                                                              e.printStackTrace();
                                                          } finally {
                                                              fos.getFD().sync();
                                                              fos.close();
                                                          }
                                                      } catch (Exception e) {
                                                          e.printStackTrace();
                                                      }

                                                  }
                                                  if (model.downPayment == 0) {
                                                      FileOutputStream fos;

                                                      try {
                                                          fos = new FileOutputStream("/sdcard/VVIJAY.txt", true);

                                                          FileWriter fWriter;

                                                          try {
                                                              fWriter = new FileWriter(fos.getFD());
                                                              Date date = new Date();

                                                              fWriter.write("A downpayment not found exception is logged" + date.toString() + "\n");
                                                              fWriter.close();
                                                          } catch (Exception e) {
                                                              e.printStackTrace();
                                                          } finally {
                                                              fos.getFD().sync();
                                                              fos.close();
                                                          }
                                                      } catch (Exception e) {
                                                          e.printStackTrace();
                                                      }

                                                  }
                                                  if (model.mortgageTerm == 0) {
                                                      FileOutputStream fos;

                                                      try {
                                                          fos = new FileOutputStream("/sdcard/VVIJAY.txt", true);

                                                          FileWriter fWriter;

                                                          try {
                                                              fWriter = new FileWriter(fos.getFD());
                                                              Date date = new Date();

                                                              fWriter.write("A mortgageterm not found exception is logged" + date.toString() + "\n");
                                                              fWriter.close();
                                                          } catch (Exception e) {
                                                              e.printStackTrace();
                                                          } finally {
                                                              fos.getFD().sync();
                                                              fos.close();
                                                          }
                                                      } catch (Exception e) {
                                                          e.printStackTrace();
                                                      }

                                                  }
                                                  if (model.interestRate == 0) {
                                                      FileOutputStream fos;

                                                      try {
                                                          fos = new FileOutputStream("/sdcard/VVIJAY.txt", true);

                                                          FileWriter fWriter;

                                                          try {
                                                              fWriter = new FileWriter(fos.getFD());
                                                              Date date = new Date();

                                                              fWriter.write("A interest rate not found exception is logged" + date.toString() + "\n");
                                                              fWriter.close();
                                                          } catch (Exception e) {
                                                              e.printStackTrace();
                                                          } finally {
                                                              fos.getFD().sync();
                                                              fos.close();
                                                          }
                                                      } catch (Exception e) {
                                                          e.printStackTrace();
                                                      }

                                                  }
                                                  if (model.propertyTax == 0) {
                                                      FileOutputStream fos;

                                                      try {
                                                          fos = new FileOutputStream("/sdcard/VVIJAY.txt", true);

                                                          FileWriter fWriter;

                                                          try {
                                                              fWriter = new FileWriter(fos.getFD());
                                                              Date date = new Date();

                                                              fWriter.write("A property tax not found exception is logged" + date.toString() + "\n");
                                                              fWriter.close();
                                                          } catch (Exception e) {
                                                              e.printStackTrace();
                                                          } finally {
                                                              fos.getFD().sync();
                                                              fos.close();
                                                          }
                                                      } catch (Exception e) {
                                                          e.printStackTrace();
                                                      }

                                                  }
                                                  if (model.propertyInsurance == 0) {
                                                      FileOutputStream fos;

                                                      try {
                                                          fos = new FileOutputStream("/sdcard/VVIJAY.txt", true);

                                                          FileWriter fWriter;

                                                          try {
                                                              fWriter = new FileWriter(fos.getFD());
                                                              Date date = new Date();

                                                              fWriter.write("A property insurance not found exception is logged" + date.toString() + "\n");
                                                              fWriter.close();
                                                          } catch (Exception e) {
                                                              e.printStackTrace();
                                                          } finally {
                                                              fos.getFD().sync();
                                                              fos.close();
                                                          }
                                                      } catch (Exception e) {
                                                          e.printStackTrace();
                                                      }

                                                  }

                                                  Toast.makeText(getBaseContext(), " Exception log File(VVIJAY.txt) saved successfully!",
                                                          Toast.LENGTH_SHORT).show();

                                              } catch (Exception e) {
                                                  e.printStackTrace();
                                              }
                                              // TODO Auto-generated method stub
                                          }
                                      }
        );

    }

    @Override
    protected void onStart() {
        super.onStart();
        }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
