package utils;


import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.ShippingType;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import models.PagamentoPagSeguro;
import br.com.uol.pagseguro.domain.AccountCredentials;

import br.com.uol.pagseguro.domain.PaymentRequest;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by emerson on 15/08/2014.
 */

public class PagamentoUtil {

    //private static final String EMAIL_LOGIN = "carteirinhaonline@gmail.com"; //EMAIL_LOGIN = "emersonjcarvalho@gmail.com";
    private static final String EMAIL_LOGIN = ToolsUtil.config.getString("pagseguro.email.login");
    private static final String PRODUCTION_TOKEN = ToolsUtil.config.getString("pagseguro.production.token");
    private static final String SANDBOX_TOKEN = ToolsUtil.config.getString("pagseguro.sandbox.token");

    private static final String  URL_PAGSEGURO_PAY_SERVICE_SANDBOX = "https://ws.sandbox.pagseguro.uol.com.br/v2/checkout";
    private static final String  URL_PAGSEGURO_PAY_SERVICE_PRODUCTION = "https://ws.pagseguro.uol.com.br/v2/checkout";

    AccountCredentials pagSeguroCredentials = null;

    //
    private static final String URL_AVISO_FALHA_PAGAMENTO = "http://www.carteirinhaonline.com.br" + "/pagsegout.jsf"; //"http://www.helmk.com.br/MUDAR_P_FACESCONTEXT";

    public String enviaPagamentoPagSeguro(PagamentoPagSeguro pagamentoPagSeguro) {

        String paymentURL = null;

        try {
            pagSeguroCredentials = new AccountCredentials(EMAIL_LOGIN, PRODUCTION_TOKEN);
            //pagSeguroCredentials = new AccountCredentials(EMAIL_LOGIN, PRODUCTION_TOKEN, SANDBOX_TOKEN);
        } catch (PagSeguroServiceException e) {
            e.printStackTrace();
        }


        if(pagSeguroCredentials == null){

            System.out.println("pagSeguroCredentials == null  ---------------");
            return "http://www.akka.io";
        }else {

            System.out.println("");
            System.out.println("::: PagamentoUtil -  enviaPagamentoPagSeguro :::");

            //PROCESSO DE PAGAMENTO PAGSEGURO
            PaymentRequest paymentRequest = new PaymentRequest();
            //paymentRequest.setCurrency(Currency.BRL);
            paymentRequest.setCurrency(Currency.BRL);


            paymentRequest.addItem(pagamentoPagSeguro.getId(), pagamentoPagSeguro.getDescription(),
                    pagamentoPagSeguro.getQuantity(), pagamentoPagSeguro.getAmount(),
                    pagamentoPagSeguro.getWeight(), pagamentoPagSeguro.getCost());

            paymentRequest.setReference(pagamentoPagSeguro.getReference());

            paymentRequest.setShippingType(ShippingType.NOT_SPECIFIED);
            paymentRequest.setShippingAddress(pagamentoPagSeguro.getCountry(), pagamentoPagSeguro.getState(),
                    pagamentoPagSeguro.getCity(), pagamentoPagSeguro.getDistrict(), pagamentoPagSeguro.getPostalCode(),
                    pagamentoPagSeguro.getStreet(), pagamentoPagSeguro.getNumber(), pagamentoPagSeguro.getComplement());

            // Sets your customer information.
            paymentRequest.setSender(pagamentoPagSeguro.getName(), pagamentoPagSeguro.getEmail(),
                    pagamentoPagSeguro.getAreaCode(), pagamentoPagSeguro.getFone());

            paymentRequest.setRedirectURL("http://www.dceunifacs.com");

            //URL paymentURL = null;
            //String urlRedirect = "FFFFALHOU";

            /**
             try {
             // Register this payment request in PagSeguro, to obtain the payment URL for redirect your customer.
             paymentURL = paymentRequest.register(new AccountCredentials(EMAIL_LOGIN, TOKEN));
             System.out.println("<<<<< paymentRequest >>>>>>");
             System.out.println(paymentURL);

             //urlRedirect = paymentURL.getPath();
             } catch (PagSeguroServiceException e) {
             try {
             paymentURL = new URL(URL_AVISO_FALHA_PAGAMENTO);
             } catch (MalformedURLException ex) {
             Logger.getLogger(PagamentoUtil.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
             }
             System.err.println(e.toString());
             }
             **/

            try {

                Boolean onlyCheckoutCode = false;

                // Set your account credentials on src/pagseguro-config.properties

                //paymentURL = paymentRequest.register(PagSeguroConfig.getAccountCredentials(), onlyCheckoutCode);
                paymentURL = paymentRequest.register(pagSeguroCredentials, onlyCheckoutCode);

                System.out.println(paymentURL);

            } catch (PagSeguroServiceException e) {
                System.err.println(e.getMessage());
            }
        }

        return paymentURL;
    }


}