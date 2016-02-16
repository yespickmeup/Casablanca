/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to2;

/**
 *
 * @author Dummy
 */
public class to_credit {

    public String credit_card_no;
    public String card_holder;
    public String author_code;
    public String bank;
    public String card_type;
    public double amount;
    public double credit_dollar;

    public to_credit(String credit_card_no, String card_holder, String author_code, String bank, String card_type, double amount, double credit_dollar) {
        this.credit_card_no = credit_card_no;
        this.card_holder = card_holder;
        this.author_code = author_code;
        this.bank = bank;
        this.card_type = card_type;
        this.amount = amount;
        this.credit_dollar = credit_dollar;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAuthor_code() {
        return author_code;
    }

    public void setAuthor_code(String author_code) {
        this.author_code = author_code;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCredit_card_no() {
        return credit_card_no;
    }

    public void setCredit_card_no(String credit_card_no) {
        this.credit_card_no = credit_card_no;
    }

    public double getCredit_dollar() {
        return credit_dollar;
    }

    public void setCredit_dollar(double credit_dollar) {
        this.credit_dollar = credit_dollar;
    }
}
