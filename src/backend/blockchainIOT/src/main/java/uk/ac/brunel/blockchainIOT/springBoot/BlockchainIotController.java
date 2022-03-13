/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.brunel.blockchainIOT.springBoot;


import uk.ac.brunel.blockchainIOT.fogBlockchain.blockService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Henri
 */

@RestController
@RequestMapping(path = "/api/fog")
public class BlockchainIotController {
    
    @GetMapping(value = "/block")
    public String getBlock(@RequestParam("block") int block) {
        return blockService.displayBlockchain(block);
    }
    
    @GetMapping(value = "/blockAll")
    public String getAllBlocks() {
        return blockService.displayBlockchain();
    }

    @PostMapping(value = "/block/add", params = {"data"})
    public boolean createBlock(@RequestParam("data") String blockData) {
        return blockService.createBlock(blockData);
    }
    
    @GetMapping(value = "/block/valid")
    public boolean getBlockValidity() {
        return blockService.ledgerValidity();
    }
    
}