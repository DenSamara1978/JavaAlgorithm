package Company;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CompanyPool {
    private List<Company> companies;

    public CompanyPool() {
        companies = new LinkedList();
    }

    public boolean addHeadCompany ( String companyName ) {
        return ( addCompany(companyName) != null );
    }

    public boolean addFilialCompany ( String companyName, String parentCompanyName, String plan, String fact ) {
        Company headCompany = findCompany(parentCompanyName);
        if ( headCompany == null )
            return false;

        Company filial = addCompany(companyName);
        if ( filial == null )
            return false;

        boolean result = filial.setParentId ( headCompany.getId ());
        result &= headCompany.addFilial ( filial.getId ());
        filial.setCountingValues ( Float.parseFloat(plan), Float.parseFloat(fact));

        return result;
    }

    private Company addCompany ( String companyName ) {
        if ( findCompany(companyName) == null ) {
            Company company = new Company(companyName);
            companies.add(company);
            return company;
        }
        else
            return null;
    }

    private Company findCompany ( String companyName ) {
        for (Company company : companies)
            if ( company.getName().equals(companyName))
                return company;
        return null;
    }

    public String getCompanies () {
        StringBuilder buffer = new StringBuilder ();
        for ( Company company : companies ) {
            buffer.append(company.getName());
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public String getStatisticOfCompanies () {
        StringBuilder buffer = new StringBuilder ();
        for ( Company company : companies ) {
            buffer.append(company.getName());
            if ( company.isFilial ())
                buffer.append(": ").append(company.getStatistic()).append(".");
            else
                buffer.append( ": has no statistics because it is a head company.");
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
