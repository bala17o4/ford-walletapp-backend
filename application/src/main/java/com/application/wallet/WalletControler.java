package com.application.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200/")
public class WalletControler {

    @Autowired
    private WalletService walletService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String greet(){
        return "Welcome to wallet application";
    }

    @PostMapping("/wallet")
    @ResponseStatus(value = HttpStatus.CREATED)
    public WalletDto addWallet(@Valid @RequestBody WalletDto wallet) throws WalletException{
        return this.walletService.registerWallet(wallet);
    }

    @GetMapping("/wallet/{id}")
    public WalletDto getWalletById(@PathVariable Integer id) throws WalletException{
        return this.walletService.getWalletById(id);
    }
//
//    @GetMapping("/wallet/{name}")
//    public WalletDto getByName(@PathVariable String name) throws WalletException{
//        return this.walletService.getWalletByName(name);
//    }

    @PutMapping("/updatewallet")
    public WalletDto updateWallet(@RequestBody WalletDto wallet) throws WalletException{
        return this.walletService.updateWallet(wallet);
    }

    @DeleteMapping("/deletewallet/{walletid}")
    public WalletDto deleteWallet(@PathVariable Integer walletid) throws WalletException{
        return this.walletService.deleteWalletById(walletid);
    }

    @PutMapping("/addfund/{id}/{amount}")
    public Double addFunds(@PathVariable Integer id,@PathVariable Double amount) throws WalletException{
        return this.walletService.addFundsToWalletById(id,amount);
    }
    @Autowired
    private WalletJpaRepository walletJpaRepository;
    @GetMapping("/login/{name}/{password}")
    public WalletDto loginAccount(@PathVariable String name, @PathVariable String password) throws WalletException{
        return this.walletJpaRepository.findByNameAndPassword(name, password);
    }

    @PutMapping("/withdraw/{id}/{amount}")
    public Double withdrawFunds(@PathVariable Integer id, @PathVariable Double amount) throws WalletException{
        return this.walletService.withdrawFundsFromWalletById(id,amount);
    }

    @PatchMapping("/transfer/{id}/{toId}/{amount}")
    public Boolean transferFunds(@PathVariable Integer id,@PathVariable Integer toId,@PathVariable Double amount) throws WalletException{
        return walletService.fundTransfer(id, toId, amount);
    }
//
    @GetMapping("/wallets")
    public Collection<WalletDto> getAllWallets(){
        return this.walletService.getAllWallets();
    }
}
