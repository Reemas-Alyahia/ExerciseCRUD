package com.example.exercicscrud2.Control;

import com.example.exercicscrud2.ApiResponse.ApiResponse;
import com.example.exercicscrud2.Model.Bank;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class Cotrol {
    ArrayList<Bank> banks=new ArrayList<>();

@GetMapping("/get")
    public ArrayList<Bank> getBanks() {
        return banks;
    }
    @PostMapping("/add")
public ApiResponse addBank(@RequestBody Bank bank) {
    banks.add(bank);
    return new ApiResponse("Done from adding");
}
    //Update customers
    @PutMapping("/update/{index}")
    public ApiResponse updateBank(@PathVariable int index,@RequestBody Bank bank) {
    banks.set(index,bank);
    return new ApiResponse("Done from updating");
    }
    //Delete customers
    @DeleteMapping("/delet/{index}")
    public ApiResponse deleteBank(@PathVariable int index) {
    banks.remove(index);
    return new ApiResponse("Done from deleting");
    }
    //Deposit money to customer
    @PutMapping("/deposit/{index}")
public ApiResponse deposit(@PathVariable int index, @RequestParam int amount) {
    if (index>=0&&index<banks.size()) {
       Bank user= banks.get(index);
       int dep= user.getBalance()+amount;
       user.setBalance(dep);
        return new ApiResponse("Done from Deposit:  "+dep);
    }
   else return new ApiResponse("something wrong");
}

    //Withdraw money from customers
    @PutMapping("/withdraw/{index}")
    public ApiResponse withdraw(@PathVariable int index,@RequestParam int amount) {
    if (index>=0&&index<banks.size()) {
        Bank user= banks.get(index);
        int wi= user.getBalance()-amount;
        user.setBalance(wi);
        return new ApiResponse("Done from withdraw:  "+wi);
    }
    return new ApiResponse("Done from withdraw");
    }

}
