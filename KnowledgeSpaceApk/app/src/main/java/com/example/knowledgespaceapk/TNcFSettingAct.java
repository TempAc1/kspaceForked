package com.example.knowledgespaceapk;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TNcFSettingAct extends Fragment {
    private TextView tnc;

    public TNcFSettingAct() { //no-args constructor required
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_t_nc_f_setting_act, container, false);
        tnc = view.findViewById(R.id.tncTvSettingAct);
        tnc.setText("END USER LICENSE AGREEMENT\n" +
                " Last updated August 25, 2022 KspAce is licensed to You (End-User) by KspAce, located and registered at Pune, Pune, Maharastra 411035, India (\"Licensor\"), for use only under the terms of this License Agreement. By downloading the Licensed Application from Apple's software distribution platform (\"App Store\") and Google's software distribution platform (\"Play Store\"), and any update thereto (as permitted by this License Agreement), You indicate that You agree to be bound by all of the terms and conditions of this License Agreement, and that You accept this License Agreement. App Store and Play Store are referred to in this License Agreement as \"Services.\" The parties of this License Agreement acknowledge that the Services are not a Party to this License Agreement and are not bound by any provisions or obligations with regard to the Licensed Application, such as warranty, liability, maintenance and support thereof. KspAce, not the Services, is solely responsible for the Licensed Application and the content thereof. This License Agreement may not provide for usage rules for the Licensed Application that are in conflict with the latest Apple Media Services Terms and Conditions and Google Play Terms of Service (\"Usage Rules\"). KspAce acknowledges that it had the opportunity to review the Usage Rules and this License Agreement is not conflicting with them. KspAce when purchased or downloaded through the Services, is licensed to You for use only under the terms of this License Agreement. The Licensor reserves all rights not expressly granted to You. KspAce is to be used on devices that operate with Apple's operating systems (\"iOS\" and \"Mac OS\") or Google's operating system (\"'Android\").\n" +
                "\n" +
                "TABLE OF CONTENTS\n" +
                " 1. THE APPLICATION\n" +
                " 2. SCOPE OF LICENSE\n" +
                " 3. TECHNICAL REQUIREMENTS \n" +
                "4. MAINTENANCE AND SUPPORT \n" +
                "5. USE OF DATA \n" +
                "6. USER-GENERATED CONTRIBUTIONS \n" +
                "7. CONTRIBUTION LICENSE \n" +
                "8. LIABILITY\n" +
                " 9. WARRANTY \n" +
                "10. PRODUCT CLAIMS\n" +
                " 11. LEGAL COMPLIANCE\n" +
                " 12. CONTACT INFORMATION \n" +
                "13. TERMINATION \n" +
                "14. THIRD-PARTY TERMS OF AGREEMENTS AND BENEFICIARY\n" +
                " 15. INTELLECTUAL PROPERTY RIGHTS \n" +
                "16. APPLICABLE LAW\n" +
                " 17. MISCELLANEOUS\n" +
                "1. THE APPLICATIOON\n" +
                " KspAce (\"Licensed Application\") is a piece of software created to Creating a full-fledged ecosystem for on-offline eductional instituions across the world. We helps in connection the gap between technology and traditions, thereby building a fluid bridge between educators and preceptors. We aim to build a solid foundation platform for creation and consuming of knowledge all around the space. and customized for ioS and Android mobile devices ('Devices\"). It is used to We aim to build a solid foundation platform for Creation and consuming of knowledge all around the space. Furthermore, it is used to We helps in connection the gap between technology and traditions, thereby building a fiuid bridge between educators and preceptors. The Licensed Application is not tailored to comply with industry-specific regulations (Health Insurance Portability and Accountability Act (HIPAA), Federal Information Security Management Act (FISMA), etc.), so if your interactions would be subjected to such laws, you may not use this Licensed Application. You may not use the Licensed Application in a way that would violate the Gramm-Leach-Bliley Act (GLBA).\n" +
                " 2. SCOPE OF LICENSE\n" +
                " 2.1 You are given a non-transferable, non-exclusive, non-sublicensable license to install and use the Licensed Application on any Devices that You (End-User) own or control and as permitted by the Usage Rules, with the exception that such Licensed Application may be accessed and used by other accounts associated with You (End-User, The Purchaser) via Family Sharing or volume purchasing. 2.2 This license will also govern any updates of the Licensed Application provided by Licensor that replace, repair, and/or supplement the first Licensed Application, unless a separate license is provided for such update, in which case the terms of that new license will goven.\n" +
                "2.3 You may not share or make the Licensed Application available to third parties (unless to the degree allowed by the Usage Rules, and with KspAce's prior written consent). sell, rent, lend, lease or otherwise redistribute the Licensed Application.\n" +
                " 2.4 You may not reverse engineer, translate, disassemble, integrate, decompile, remove, modfy, combine, create derivative works or updates of, adapt, or attempt to derive the source code of the Licensed Application, or any part thereof (except with KspAce's prior written consent).\n" +
                " 2.5 You may not copy (excluding when expressly authorized by this license and the Usage Rules) or alter the Licensed Application or portions thereof. You may create and store coples only on devices that You own or control for backup keeping under the terms of this license, the Usage Rules, and any other terms and conditions that apply to the device or software used. You may not remove any intellectual property notices. You acknowiedge that no unauthorized third parties may gain access to these copies at any time. if you sell your Devices to a third party, you must remove the Licensed Application from the Devices berore doing so. \n" +
                "2.6 Violations of the obligations mentioned above, as well as the attempt of such infringement, may be subject to prOsecution and damages.\n" +
                " 2.7 Licensor reserves the right to modity the terms and conditions of licensing9. \n" +
                "2.8 Nothing in this license should be interpreted to restrict third-party terms. When using the Licensed Application, You must ensure that You comply with applicable third-party terms and conditions. \n" +
                "3. TECHNICAL REQUIREMENTs\n" +
                " 3.1 The Licensed Application requires a firmware version 1.0.0 or higher. Licensor recommends using the latest version or the firmware. \n" +
                "3.2 Licensor attempts to keep the Licensed Application updated so that it complies With modified/new versions of the firmware and new hardware. You are not granted rights to Claim such an update. \n" +
                "3.3 You acknowledge that it is Your responsibility to confirm and determine that the app end-user device on which You intend to use the Licensed Application satisfies the technical specification mentioned above. \n" +
                "3.4 Licensor reserves the right to modify the technical specifications as it sees appropriate at any time.\n" +
                " 4. MAINTENANCE AND SUPPORT \n" +
                "4.1 The Licensor is Solely responsible for providing any maintenance and support services for this Licensed Application. You can reach the Licensor at the email address listed in the App Store or Play Store Overview for this Licensed Application.\n" +
                " 4.2 KspAce and the End-user acknowledge that the services have no obligation whatsoever to Tarnish any maintenance and support services with respect to the Licensed Application.\n" +
                " 5. USE OF DATA \n" +
                "You acknowledge that Licensor will be able to access and adjust Your downloaded Licensed Application content and Your personal information, and that Licensor's use of such material and information is subject to Your legal agreements with Licensor and Licensors privacy policy, which can be found at the bottom of the Licensed Application. You acknowledge that the Licensor may periodically collect and use technical data and related information about your device, system, and application software, and peripherals, offer\n" +
                "3. TECHNICAL REQUIREMENTS\n" +
                " The Licensed Application requires a firmware version 1.o.0 or higher. Licensor recommends using the latest version of the firmware. 2 Licensor attempts to keep the Licensed Application updated so that it complies with modified/new versions of the fimware and new hardware. You are not granted rights 3.3 You acknowiedge that it is Your responsibility to contim and determine that the app end-user device on wnich You ntend to use the Lioensed Application satisties the ecal speciticabons mentioned above. . DenEo eseve e ngnt to mcoiny te enies s cns 5 t Sees pcprsie st Sny tme 4. MAINTENANCE AND SUPPORT \n" +
                "4.1 The Lice for pro Fisted in the App Store or Play Store Overview for this Licensed Application. onsib Support services tor this Licensed Application. You can reach the Dicensor at the email address 4.2 KspACe and the End-user ackknowiedge that the Services have no oblgation wnatsoever to furmish any maintenance and support services with respect to the Licensed \n" +
                "5. USE OF DATA ou acknowiledge that Licensor will be naterial and information is subiect to Your legal aareements with Licensor and Licensors privacy policy. which can be found at the bottom of the Licensed Apclication. and adjust Your downloaded Licensed ontent and Your personal information, and tha ou zen ge tnt e Deenser may pecey cot e use tecicct ne reenrommaton dpour yeur cevce, system, d 9p n SoWee, nc nay also use this information to imorove its products or to orovide services or technologies to you. as lona as it is in a form that does not personalv identify vou. \n" +
                "\n" +
                "6. USER-GENERATED CONTRIBUTIONS\n" +
                " he Licensed Application may invite you to chat, contribute to, or participate in biogs, message b0ards, online torums, and other functionality. and may provide you with the opportunity to create, suDmit. post. display. transmit. pertorm. publish, distribute, or broadcast content and maternals to us or in the Licensed ApplNcation, ncluding but not mited to text, wrtings, video, audio, photographs. graphics, comments, Suggestions, or persona nformaton or other matenal (colectively. ontributions). Contributons ay be viewable by other users af the Licensed Application and through third-party websites or appications. AS SUch, any Contributbons you trans mit may be treated as non- ontidential and non-propnetary. Wnen you reate or make avaiable any Contribubions. you thereby represent and warrant that:\n" +
                " 1. Ihe creaton, distibubion, transmission. public display, or pertormance, and the accessing. downloading. or copying of your Contrnibutions do not and willnot infninge the eprey ens, ceing but mote t tne copyent. patent, tepemsK, UEDe seerer, er hioe ents or ny tre pEny. .You re ne createre cwerOr er nave e necessy enss, ents, censents, s, e pemssns to usee to u e us, tne Leensed Apcaben, Enc indie\n" +
                " 3. You have the written consent, release, and/or permission of each and every identifiable individual person in your Contributions to use the name or likeness or each and every such identifiabe individua person to enabie inciusion and use of your contribubons in any manner contemplated by the Licensed Application and this License . Yeur entieutes re ret Ese, nauete, c hiseie . Your contrbubons are not unsolicited or unauthorzed advertsing. promotional materals,. Pyramid schemes, chain etters, spam, mass maings. or other toms of 0. Your Contributons are not obscene, lewa, lasCIVIOUS, fitny, violent, harassing. liDelous, sianderous, or otherwise oojectonabe (as determined by us). \n" +
                "1. Your Contributons do not naicule, mock, disparage. intimidate, or abuse anyone. 8. Your Contributons are not used to harass or threaten (in the egal sense of those terms) any other person and to promote violence against a specitic person or ciass Of Contributions do not V Og mublicity rights of any thire panY 10. Your Contributions do not violate the privacy or publicity rights of any th .Your Contributions do not violate any applicabie aw concerming chid pormography. or otherWse imtended to protect the heaith or we-being of minors.\n" +
                " 2. Your ontriutons 0o not ineoe ny ctensve coinents tnt re ceneeted to reee, naten crgn. ge,sexu prerereee, Cr pmys nep. \n" +
                "13. Your Contributions do not othewise violate, or ink to materal that violates, any provision of this License Agreement, or any applicable law or regulation. Any use of the Licensed Application in violation of the foregoing violates this License Agreement and may result in, among other things. terminaton or suspens ion of your ents o use e Dense pcc \n" +
                "10. PRODUCT CLAIMS \n" +
                "KspACe and the End-User acknowledge that KspAce, and not the services, Is responsible for addressing any claims of the End-User or any third party relating to the Licensed Application or the End-User's possession and/or use of that Licensed Application, including, but not limited to: 0 product liability claims, () any claim that the Licensed Application this to contort to any applicable legal or regulatory requirement, and (ii) claims arising under consumer protection, privacy, or similar legislation, including in connection with Your Licensed Application's use of the Health Kit and HomeKit. 11. LEGAL COMPLIANCE You represent and warrant that You are not located in a country that is subject to a Us Government embargo, or that has been designated by the Us Government as a \"terrorist Supporting\" country, and that You are not listed on any Us Government list of prohibited or restricted parties. 12. CONTACT INFORMATION For general inquiries, complaints, questions or claims concerning the Licensed Application, please contact KspAce Pune Pune, Maharastra 411035 India demo@gmail.com 13. TERMINATION The license is valid until terminated by KspAce or by You. Your rights under this license ill terminate automatically and without notice from KspAce if You fail to adhere to any term(s) of this license. Upon License termination, You shall stop ll use of the Licensed Application, and destroy all couples, full or partial, of the Licensed Application.\n");

        /**Your Code here */
        tnc.setMovementMethod(new ScrollingMovementMethod());
        return  view;
    }

}