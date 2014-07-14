package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


        public static final String coinName = "Kazcoin";
        public static final String coinTicker = "KZC";
        public static final String coinURIScheme = "KZC";
        public static final String cryptsyMarketId = "33";
        public static final String cryptsyMarketCurrency = "BTC";
        public static final String alternateExchangeInfo = "http://www.frankos.org/coin_api.php?coin_id=33";


        public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://block.gaelcoin.org/";
        public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://block.gaelcoin.org/";

        public static final String DONATION_ADDRESS = "F85ytB5qH87aHskpauQi6YWdRZPQgNubX4";  //HashEngineering donation FRK address

        enum CoinHash {
            SHA256,
            scrypt
        };
        public static final CoinHash coinHash = CoinHash.scrypt;
        //Original Values
        public static final int TARGET_TIMESPAN = (int)(60 * 60);  // 720 blocks; 6 hours
        public static final int TARGET_SPACING = (int)(1 * 60);  // 30 seconds per block.

        public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  // 720 blocks

        public static final int getInterval(int height, boolean testNet) {

            return INTERVAL;
        }
        public static final int getTargetTimespan(int height, boolean testNet) {

            return TARGET_TIMESPAN;
        }
        public static int spendableCoinbaseDepth = 5; //main.h: static const int COINBASE_MATURITY
        public static final int MAX_MONEY = 640000000;                 //main.h:  MAX_MONEY
        public static final String MAX_MONEY_STRING = "640000000";     //main.h:  MAX_MONEY

        public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(100);   // MIN_TX_FEE
        public static final BigInteger DUST_LIMIT =      Utils.toNanoCoins("0.0000100"); //main.h DUST_SOFT_LIMIT        0.0001 coins
        public static final BigInteger DUST_HARD_LIMIT = Utils.toNanoCoins("0.00000010"); //main.h DUST_HARD_LIMIT        0.00001 coins

        public static final int PROTOCOL_VERSION = 70002;          //version.h PROTOCOL_VERSION
        public static final int MIN_PROTOCOL_VERSION = 209;        //version.h MIN_PROTO_VERSION

        public static final boolean supportsBloomFiltering = false; //Requires PROTOCOL_VERSION 70000 in the client

        public static final int Port    = 7933;       //protocol.h GetDefaultPort(testnet=false)
        public static final int TestPort = 22622;     //protocol.h GetDefaultPort(testnet=true)

        //
        //  Production
        //
        public static final int AddressHeader = 46;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
        public static final int p2shHeader = 5;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
        //public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
        public static final long PacketMagic = 0xfbc0b6dbL;      //// Franko: 7(lucky number) defaced.

        //Genesis Block Information from main.cpp: LoadBlockIndex
        static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
        static public long genesisBlockTime = 1404726550L;                       //main.cpp: LoadBlockIndex
        static public long genesisBlockNonce = (305457);                         //main.cpp: LoadBlockIndex
        static public String genesisHash = "ea09f08d083b7edc86c5e4bec95f122a35bd089b9baf872174cb017ec7463e1a"; //main.cpp: hashGenesisBlock
        static public int genesisBlockValue = 0;                                                              //main.cpp: LoadBlockIndex
        //taken from the raw data of the block explorer
        static public String genesisXInBytes = "04ffff001d01040a30342e30362e31393837";   //"5/9/2013 Aiden will be a year old in two months"
        static public String genessiXOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

        //net.cpp strDNSSeed
        static public String[] dnsSeeds = new String[] {
                "kazcoins.org", 

        };

        //
        // TestNet - Franko - not tested
        //
        public static final boolean supportsTestNet = false;
        public static final int testnetAddressHeader = 112;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
        public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
        public static final long testnetPacketMagic = 0x9defaced;      //0xfc, 0xc1, 0xb7, 0xdc
        public static final String testnetGenesisHash = "62108bdd14b8452692b4c0f624d20c4d088d08646a630472345b25ec27034a28";
        static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
        static public long testnetGenesisBlockTime = 1368187357L;                       //main.cpp: LoadBlockIndex
        static public long testnetGenesisBlockNonce = (385607496);                         //main.cpp: LoadBlockIndex



        public static int nDifficultySwitchHeight = 400000;


        public static final boolean usingNewDifficultyProtocol(int height)
        { return height >= nDifficultySwitchHeight;}



        //main.cpp GetBlockValue(height, fee)

        public static final BigInteger GetBlockReward(int height)
        {
            return Utils.toNanoCoins(0, 25).shiftRight(height / subsidyDecreaseBlockCount);
        }

        public static int subsidyDecreaseBlockCount = 10;     //main.cpp GetBlockValue(height, fee)

        public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // Franko: starting difficulty is 1 / 2^12

        static public String[] testnetDnsSeeds = new String[] {
                "not supported"
        };
        //from main.h: CAlert::CheckSignature
        public static final String SATOSHI_KEY = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";
        public static final String TESTNET_SATOSHI_KEY = "04302390343f91cc401d56d68b123028bf52e5fca1939df127f63c6467cdf9c8e2c14b61104cf817d0b780da337893ecc4aaff1309e536162dabbdb45200ca2b0a";
        /** The string returned by getId() for the main, production network where people trade things. */
        public static final String ID_MAINNET = "org.franko.production";
        /** The string returned by getId() for the testnet. */
        public static final String ID_TESTNET = "org.franko.test";
        /** Unit test network. */
        public static final String ID_UNITTESTNET = "com.google.franko.unittest";

        //checkpoints.cpp Checkpoints::mapCheckpoints
        public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
        {


        }
}
