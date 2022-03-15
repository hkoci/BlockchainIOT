/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.brunel.blockchainIOT.springBoot;


import uk.ac.brunel.blockchainIOT.fogBlockchain.blockService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    //Get specific block using blockNum identifier param
    @GetMapping(value = "/block")
    public String getBlock(@RequestParam("blockNum") int block) {
        return blockService.displayBlockchain(block);
    }
    
    //Get specific block using the block identifier in the URI
    @GetMapping(value = "/block/{id}")
    public String getBlockID(@PathVariable("id") int block) {
        return blockService.displayBlockchain(block);
    }
    
    //Display all blocks
    @GetMapping(value = "/block/all")
    public String getAllBlocks() {
        return blockService.displayBlockchain();
    }

    //Add block using data param
    @PostMapping(value = "/block")
    public boolean createBlock(@RequestParam("data") String blockData) {
        return blockService.createBlock(blockData);
    }
    
    //Mine the last block
    @GetMapping(value = "/block/mine")
    public void mineLastBlock() {
        blockService.mineBlock();
    }
    
    //Mine the last block
    @GetMapping(value = "/block/mine/difficulty")
    public int getMinerDifficulty() {
        return blockService.getMiningDifficulty();
    }
    
    //Change mining difficulty using data param
    @PostMapping(value = "/block/mine/difficulty")
    public void minerSetDifficulty(@RequestParam("difficulty") int difficulty) {
        blockService.setMiningDifficulty(difficulty);
    }

    //Remove blockchain data
    @GetMapping(value = "/block/clear")
    public void clearAllBlocks() {
        blockService.clearBlocks();
    }
    
    //Check block validity
    @GetMapping(value = "/block/valid")
    public boolean getBlockValidity() {
        return blockService.ledgerValidity();
    }
    
}