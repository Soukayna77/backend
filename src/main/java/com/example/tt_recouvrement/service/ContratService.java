package com.example.tt_recouvrement.service;


import com.example.tt_recouvrement.model.Client;
import com.example.tt_recouvrement.model.Contrat;
import com.example.tt_recouvrement.model.Facture;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.repository.ContratRepository;
import com.example.tt_recouvrement.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.*;

@Service
public class ContratService {


    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private FactureRepository factureRepository;


    public Response<Contrat> saveContrat(Contrat contrat, Client client) {

        contrat.setCreated(new Date());

        YearMonth yearMonthObject = YearMonth.of(contrat.getDateStart().getYear(), contrat.getDateStart().getMonth()+1);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        System.out.println("nombre de jour est :"+daysInMonth);
        System.out.println("prix /12 est  :"+(double)contrat.getAmountTotal()/12 );

        int date =contrat.getDateStart().getDate();
        int month = contrat.getDateStart().getMonth();
        int year = contrat.getDateStart().getYear();





        contrat.setDateEnd(new Date(year+1,month,date));

        List<Facture> factureList = new ArrayList<Facture>();


        List<Facture> newListFactures = new ArrayList<Facture>();

        List<Integer> listInt= new ArrayList<Integer>();


        switch (contrat.getPaymentPeriod()) {
            case MENSUEL:
/*                System.out.println("day "+contrat.getDateStart().getDay());
                System.out.println("month "+contrat.getDateStart().getMonth());
                System.out.println("year "+contrat.getDateStart().getYear());
                Date auj = new Date();
               // int nombre_jour = auj.get
                System.out.println();*/





                for (int i = 0; i < 12; i++) {

                    int da = (int) new Date().getTime();

                    String random= Integer.toString(da);


                    String numFactur= Integer.toString(date) + Integer.toString(month) + Integer.toString(year) + random.substring(6,9) + Integer.toString(i);
                    System.out.println(numFactur);

                    Facture facture = new Facture((double)contrat.getAmountTotal()/12,contrat.getName());
                    facture.setNumFacture(Long.parseLong(numFactur));
                    facture.setDateStart(new Date(year,(month+i),date+1));
                    facture.setDateEnd(new Date(year,(month+i+1),(date)));

                    factureList.add(facture);
                    //factureRepository.save(facture);
                    //newListFactures.add(factureRepository.save(facture));
                    listInt.add(i);

                    SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String startDate = newFormat.format(facture.getDateStart());
                    String endDate = newFormat.format(facture.getDateEnd());


                    System.out.println("start date :"+startDate);
                   // System.out.println("start date :"+facture.getDateStart());

                    System.out.println("end   date :"+endDate);



                }

                 newListFactures = factureRepository.saveAll(factureList);



                contrat.setFactures(newListFactures);


                //result = "domestic animal";
                break;
            case TRIMESTRIEL:
                for (int i = 0; i < 12; i=i+3) {


                    int da = (int) new Date().getTime();

                    String random= Integer.toString(da);


                    String numFactur= Integer.toString(date) + Integer.toString(month) + Integer.toString(year) + random.substring(6,9) + Integer.toString(i);
                    System.out.println(numFactur);

                    Facture facture = new Facture((double)contrat.getAmountTotal()/12,contrat.getName());
                    facture.setNumFacture(Long.parseLong(numFactur));

                    facture.setDateStart(new Date(year,(month+i),date+1));
                    facture.setDateEnd(new Date(year,(month+i+3),(date)));

                    factureList.add(facture);
                    //factureRepository.save(facture);
                    //newListFactures.add(factureRepository.save(facture));
                    listInt.add(i);

                    SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String startDate = newFormat.format(facture.getDateStart());
                    String endDate = newFormat.format(facture.getDateEnd());


                    System.out.println("start date :"+startDate);
                    // System.out.println("start date :"+facture.getDateStart());

                    System.out.println("end   date :"+endDate);



                }

                newListFactures = factureRepository.saveAll(factureList);



                contrat.setFactures(newListFactures);
                break;
            case SEMI_ANNUEL:
                System.out.println("here annuel");
                for (int i = 0; i < 12; i=i+6) {
                    int da = (int) new Date().getTime();

                    String random= Integer.toString(da);


                    String numFactur= Integer.toString(date) + Integer.toString(month) + Integer.toString(year) + random.substring(6,9) + Integer.toString(i);
                    System.out.println(numFactur);

                    Facture facture = new Facture((double)contrat.getAmountTotal()/12,contrat.getName());
                    facture.setNumFacture(Long.parseLong(numFactur));

                    facture.setDateStart(new Date(year,(month+i),date+1));
                    facture.setDateEnd(new Date(year,(month+i+6),(date)));

                    factureList.add(facture);
                    //factureRepository.save(facture);
                    //newListFactures.add(factureRepository.save(facture));
                    listInt.add(i);

                    SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String startDate = newFormat.format(facture.getDateStart());
                    String endDate = newFormat.format(facture.getDateEnd());


                    System.out.println("start date :"+startDate);
                    // System.out.println("start date :"+facture.getDateStart());

                    System.out.println("end   date :"+endDate);



                }

                newListFactures = factureRepository.saveAll(factureList);



                contrat.setFactures(newListFactures);
                break;
            default:
                //result = "unknown animal";
                for (int i = 0; i < 1; i++) {
                    int da = (int) new Date().getTime();

                    String random= Integer.toString(da);


                    String numFactur= Integer.toString(date) + Integer.toString(month) + Integer.toString(year) + random.substring(6,9) + Integer.toString(i);
                    System.out.println(numFactur);

                    Facture facture = new Facture((double)contrat.getAmountTotal()/12,contrat.getName());
                    facture.setNumFacture(Long.parseLong(numFactur));

                    facture.setDateStart(new Date(year,(month+i),date+1));
                    facture.setDateEnd(new Date(year,(month+12*i+1),(date)));

                    factureList.add(facture);
                    //factureRepository.save(facture);
                    //newListFactures.add(factureRepository.save(facture));
                    listInt.add(i);

                    SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String startDate = newFormat.format(facture.getDateStart());
                    String endDate = newFormat.format(facture.getDateEnd());


                    System.out.println("start date :"+startDate);
                    // System.out.println("start date :"+facture.getDateStart());

                    System.out.println("end   date :"+endDate);



                }

                newListFactures = factureRepository.saveAll(factureList);



                contrat.setFactures(newListFactures);
                break;
        }

/*        List<Contrat> contratListClient = new ArrayList<Contrat>();
        contratListClient = client.getContrats();
        client.setContrats(null);
        contrat.setClient(client);
        Contrat newContrat = contratRepository.save(contrat);
        contratListClient.add(newContrat);
        client.setContrats(contratListClient);
        clientService.updateClient(client,client.getId());*/

        contrat.setClient(client);
        return new Response<>("200","save contrat",contratRepository.save(contrat));
    }

    public Response<Contrat> saveContrat1(Contrat contrat) {

      /*  int date = contrat.getDateStart().getDate();
        int month = contrat.getDateStart().getMonth();
        int year = contrat.getDateStart().getYear();*/

        contrat.setCreated(new Date());

        Date date = contrat.getDateStart();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("day "+day);
        System.out.println("month "+month);
        System.out.println("year "+year);

        contrat.setDateEnd(new Date(year-1899,month-1,day));

        List<Facture> factureList = new ArrayList<Facture>();
        Facture facture = new Facture((double)contrat.getAmountTotal()/12,contrat.getName());


        for (int i = 0; i < 12; i++) {
            Date startDate2 = new Date(year-1901,(month+i),day+1);
            facture.setDateStart(startDate2);
            facture.setDateEnd(new Date(year-1901,(month+i+1),(day)));


            //factureRepository.save(facture);
            //newListFactures.add(factureRepository.save(facture));


           /* SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
            String startDate = newFormat.format(facture.getDateStart());
            String endDate = newFormat.format(facture.getDateEnd());


            System.out.println("start date :"+startDate);
            // System.out.println("start date :"+facture.getDateStart());

            System.out.println("end   date :"+endDate);*/

            SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
            String startDate = newFormat.format(facture.getDateStart());
            String endDate = newFormat.format(facture.getDateEnd());

            System.out.println("start date :"+startDate);
            // System.out.println("start date :"+facture.getDateStart());

            System.out.println("end   date :"+endDate);

            factureList.add(facture);

        }
        for (Facture fac:factureList
             ) {
            System.out.println("start   date :"+fac.getDateStart());

        }
        contrat.setFactures(factureList);



        return new Response<>("200","save contrat",contratRepository.save(contrat));

    }

    public Response<Contrat> updateContrat(Contrat contrat, String id_contrat,String    id_facture) {
        //contrat.setId(id_contrat);

        Contrat contrat1 = contratRepository.findById(id_contrat).orElse(null);

        List<Facture> factureList = new ArrayList<Facture>();

        factureList = contrat1.getFactures();

        for (Facture fac : contrat1.getFactures()) {
            System.out.println("here facture FOR | "+ fac.getId() + " | here path variable | "+id_facture);

            if(fac.getId().equals(id_facture)){
                System.out.println("here facture");

                fac.setEtat(true);
            }
        }
        //contrat1.setFactures(factureList);
        System.out.println("here update contrat service");
        return new Response<>("200","update contrat",contratRepository.save(contrat1));
    }

    public Response<List<Contrat>> getAll() {
        return new Response<>("200","all contrat",contratRepository.findAll());
    }

    public Response<Contrat> deleteContrat(String id_contrat) {
        try{
            contratRepository.findById(id_contrat).get();
            contratRepository.deleteById(id_contrat);
            return new Response<>("200","deleted contrat",null);
        } catch (Exception e) {
            return new Response<>("406","not found contrat",null);
        }
    }

    public Response<Contrat> getByIdContrat(String id_contrat) {
        try{
            return new Response<>("200","get contrat with id "+id_contrat,contratRepository.findById(id_contrat).get());
        } catch (Exception e) {
            return new Response<>("406","contrat not found",null);
        }
    }


}
