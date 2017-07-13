package com.jdriven.ng2boot;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chimbs on 7/6/17.
 */
public class UrlMaker {
    Date startDate = new Date();
    Date endDate = new Date();
    String url = "";
    String ticker = "";
    private static final String BASE_URL = "https://api.intrinio.com/companies?ticker=";
    private static final String HISTORICAL = "https://api.intrinio.com/historical_data?identifier=<ticker>&item=high_price&start_date=<START>&end_date=<END>&frequency=monthly";

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public String getUrlForTicker() {
        return BASE_URL + ticker;
    }

    public String getUrlForHistoric() {
        return HISTORICAL.replace("<ticker>", ticker.toUpperCase()).replace("<START>", df.format(startDate)).replace("<END>", df.format(endDate));
    }

    public static class Builder {
        private UrlMaker urlMaker = new UrlMaker();

        public Builder withStartDate(DateTime date) {
            urlMaker.startDate = new Date(date.getMillis());
            return this;
        }

        public Builder withEndtDate(DateTime date) {
            urlMaker.endDate = new Date(date.getMillis());
            return this;
        }

        public Builder withUrl(String url) {
            urlMaker.url = url;
            return this;
        }

        public Builder withTicker(String url) {
            urlMaker.ticker = url;
            return this;
        }

        public UrlMaker build() {
            return urlMaker;
        }
    }

}
