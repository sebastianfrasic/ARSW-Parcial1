package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.model.PrimeException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@Service("primeServicesStub")
public class PrimeServiceStub implements PrimeService {

    private List<FoundPrime> primos = new CopyOnWriteArrayList<>();

    public PrimeServiceStub() {
        primos.add(new FoundPrime("Frasica", "368"));
        primos.add(new FoundPrime("Marian", "715"));
        primos.add(new FoundPrime("Frasica", "4567"));
    }

    @Override
    public void addFoundPrime(FoundPrime foundPrime) throws PrimeException {
        for (FoundPrime prime : primos) {
            if (prime.getPrime().equals(foundPrime.getPrime())) {
                throw new PrimeException("Ese numero primo ya existe");
            }
        }
        primos.add(foundPrime);
    }

    @Override
    public List<FoundPrime> getFoundPrimes() {
        return primos;
    }

    @Override
    public FoundPrime getPrime(String prime) throws PrimeException {
        for (FoundPrime primo : primos) {
            if (primo.getPrime().equals(prime)) {
                return primo;
            }
        }
        throw new PrimeException("Ese numero primo no existe");
    }
}
