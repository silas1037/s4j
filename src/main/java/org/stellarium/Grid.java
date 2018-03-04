/*
 * Stellarium
 * Copyright (C) 2002 Fabien Ch�reau
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.stellarium;

import javax.vecmath.Tuple3d;
import javax.vecmath.Vector3d;

public class Grid {

    static void moy(Vector3d[] p, int a, int b, int c) {
        p[c] = new Vector3d();
        p[c].add(p[a], p[b]);
        p[c].normalize();
    }

    double tempTab[][] = {
            {0.0000d, 0.0000d, 1.0000d},
            {0.8944d, 0.0000d, 0.4472d},
            {0.2764d, 0.8507d, 0.4472d},
            {-0.7236d, 0.5257d, 0.4472d},
            {-0.7236d, -0.5257d, 0.4472d},
            {0.2764d, -0.8507d, 0.4472d},
            {0.7236d, 0.5257d, -0.4472d},
            {-0.2764d, 0.8507d, -0.4472d},
            {-0.8944d, -0.0000d, -0.4472d},
            {-0.2764d, -0.8507d, -0.4472d},
            {0.7236d, -0.5257d, -0.4472d},
            {0.0000d, 0.0000d, -1.0000d},
            {0.1575d, 0.0000d, 0.9875d},
            {0.3111d, 0.0000d, 0.9504d},
            {0.4569d, 0.0000d, 0.8895d},
            {0.5913d, 0.0000d, 0.8065d},
            {0.7109d, 0.0000d, 0.7033d},
            {0.8128d, 0.0000d, 0.5825d},
            {0.0487d, 0.1498d, 0.9875d},
            {0.0961d, 0.2959d, 0.9504d},
            {0.1412d, 0.4345d, 0.8895d},
            {0.1827d, 0.5623d, 0.8065d},
            {0.2197d, 0.6761d, 0.7033d},
            {0.2512d, 0.7730d, 0.5825d},
            {-0.1274d, 0.0926d, 0.9875d},
            {-0.2517d, 0.1828d, 0.9504d},
            {-0.3696d, 0.2686d, 0.8895d},
            {-0.4784d, 0.3476d, 0.8065d},
            {-0.5752d, 0.4179d, 0.7033d},
            {-0.6576d, 0.4778d, 0.5825d},
            {-0.1274d, -0.0926d, 0.9875d},
            {-0.2517d, -0.1828d, 0.9504d},
            {-0.3696d, -0.2686d, 0.8895d},
            {-0.4784d, -0.3476d, 0.8065d},
            {-0.5752d, -0.4179d, 0.7033d},
            {-0.6576d, -0.4778d, 0.5825d},
            {0.0487d, -0.1498d, 0.9875d},
            {0.0961d, -0.2959d, 0.9504d},
            {0.1412d, -0.4345d, 0.8895d},
            {0.1827d, -0.5623d, 0.8065d},
            {0.2197d, -0.6761d, 0.7033d},
            {0.2512d, -0.7730d, 0.5825d},
            {0.8615d, 0.1498d, 0.4852d},
            {0.8071d, 0.2959d, 0.5110d},
            {0.7325d, 0.4345d, 0.5241d},
            {0.6396d, 0.5623d, 0.5241d},
            {0.5308d, 0.6761d, 0.5110d},
            {0.4087d, 0.7730d, 0.4852d},
            {0.1238d, 0.8656d, 0.4852d},
            {-0.0320d, 0.8590d, 0.5110d},
            {-0.1869d, 0.8309d, 0.5241d},
            {-0.3372d, 0.7821d, 0.5241d},
            {-0.4790d, 0.7137d, 0.5110d},
            {-0.6089d, 0.6276d, 0.4852d},
            {-0.7850d, 0.3852d, 0.4852d},
            {-0.8268d, 0.2350d, 0.5110d},
            {-0.8480d, 0.0790d, 0.5241d},
            {-0.8480d, -0.0790d, 0.5241d},
            {-0.8268d, -0.2350d, 0.5110d},
            {-0.7850d, -0.3852d, 0.4852d},
            {-0.6089d, -0.6276d, 0.4852d},
            {-0.4790d, -0.7137d, 0.5110d},
            {-0.3372d, -0.7821d, 0.5241d},
            {-0.1869d, -0.8309d, 0.5241d},
            {-0.0320d, -0.8590d, 0.5110d},
            {0.1238d, -0.8656d, 0.4852d},
            {0.4087d, -0.7730d, 0.4852d},
            {0.5308d, -0.6761d, 0.5110d},
            {0.6396d, -0.5623d, 0.5241d},
            {0.7325d, -0.4345d, 0.5241d},
            {0.8071d, -0.2959d, 0.5110d},
            {0.8615d, -0.1498d, 0.4852d},
            {0.9402d, 0.0926d, 0.3277d},
            {0.9626d, 0.1828d, 0.1999d},
            {0.9609d, 0.2686d, 0.0672d},
            {0.9352d, 0.3476d, -0.0672d},
            {0.8862d, 0.4179d, -0.1999d},
            {0.8151d, 0.4778d, -0.3277d},
            {0.2025d, 0.9228d, 0.3277d},
            {0.1236d, 0.9720d, 0.1999d},
            {0.0415d, 0.9969d, 0.0672d},
            {-0.0415d, 0.9969d, -0.0672d},
            {-0.1236d, 0.9720d, -0.1999d},
            {-0.2025d, 0.9228d, -0.3277d},
            {-0.8151d, 0.4778d, 0.3277d},
            {-0.8862d, 0.4179d, 0.1999d},
            {-0.9352d, 0.3476d, 0.0672d},
            {-0.9609d, 0.2686d, -0.0672d},
            {-0.9626d, 0.1828d, -0.1999d},
            {-0.9402d, 0.0926d, -0.3277d},
            {-0.7063d, -0.6276d, 0.3277d},
            {-0.6713d, -0.7137d, 0.1999d},
            {-0.6195d, -0.7821d, 0.0672d},
            {-0.5523d, -0.8309d, -0.0672d},
            {-0.4714d, -0.8590d, -0.1999d},
            {-0.3786d, -0.8656d, -0.3277d},
            {0.3786d, -0.8656d, 0.3277d},
            {0.4714d, -0.8590d, 0.1999d},
            {0.5523d, -0.8309d, 0.0672d},
            {0.6195d, -0.7821d, -0.0672d},
            {0.6713d, -0.7137d, -0.1999d},
            {0.7063d, -0.6276d, -0.3277d},
            {0.9402d, -0.0926d, 0.3277d},
            {0.9626d, -0.1828d, 0.1999d},
            {0.9609d, -0.2686d, 0.0672d},
            {0.9352d, -0.3476d, -0.0672d},
            {0.8862d, -0.4179d, -0.1999d},
            {0.8151d, -0.4778d, -0.3277d},
            {0.3786d, 0.8656d, 0.3277d},
            {0.4714d, 0.8590d, 0.1999d},
            {0.5523d, 0.8309d, 0.0672d},
            {0.6195d, 0.7821d, -0.0672d},
            {0.6713d, 0.7137d, -0.1999d},
            {0.7063d, 0.6276d, -0.3277d},
            {-0.7063d, 0.6276d, 0.3277d},
            {-0.6713d, 0.7137d, 0.1999d},
            {-0.6195d, 0.7821d, 0.0672d},
            {-0.5523d, 0.8309d, -0.0672d},
            {-0.4714d, 0.8590d, -0.1999d},
            {-0.3786d, 0.8656d, -0.3277d},
            {-0.8151d, -0.4778d, 0.3277d},
            {-0.8862d, -0.4179d, 0.1999d},
            {-0.9352d, -0.3476d, 0.0672d},
            {-0.9609d, -0.2686d, -0.0672d},
            {-0.9626d, -0.1828d, -0.1999d},
            {-0.9402d, -0.0926d, -0.3277d},
            {0.2025d, -0.9228d, 0.3277d},
            {0.1236d, -0.9720d, 0.1999d},
            {0.0415d, -0.9969d, 0.0672d},
            {-0.0415d, -0.9969d, -0.0672d},
            {-0.1236d, -0.9720d, -0.1999d},
            {-0.2025d, -0.9228d, -0.3277d},
            {0.6089d, 0.6276d, -0.4852d},
            {0.4790d, 0.7137d, -0.5110d},
            {0.3372d, 0.7821d, -0.5241d},
            {0.1869d, 0.8309d, -0.5241d},
            {0.0320d, 0.8590d, -0.5110d},
            {-0.1238d, 0.8656d, -0.4852d},
            {-0.4087d, 0.7730d, -0.4852d},
            {-0.5308d, 0.6761d, -0.5110d},
            {-0.6396d, 0.5623d, -0.5241d},
            {-0.7325d, 0.4345d, -0.5241d},
            {-0.8071d, 0.2959d, -0.5110d},
            {-0.8615d, 0.1498d, -0.4852d},
            {-0.8615d, -0.1498d, -0.4852d},
            {-0.8071d, -0.2959d, -0.5110d},
            {-0.7325d, -0.4345d, -0.5241d},
            {-0.6396d, -0.5623d, -0.5241d},
            {-0.5308d, -0.6761d, -0.5110d},
            {-0.4087d, -0.7730d, -0.4852d},
            {-0.1238d, -0.8656d, -0.4852d},
            {0.0320d, -0.8590d, -0.5110d},
            {0.1869d, -0.8309d, -0.5241d},
            {0.3372d, -0.7821d, -0.5241d},
            {0.4790d, -0.7137d, -0.5110d},
            {0.6089d, -0.6276d, -0.4852d},
            {0.7850d, -0.3852d, -0.4852d},
            {0.8268d, -0.2350d, -0.5110d},
            {0.8480d, -0.0790d, -0.5241d},
            {0.8480d, 0.0790d, -0.5241d},
            {0.8268d, 0.2350d, -0.5110d},
            {0.7850d, 0.3852d, -0.4852d},
            {0.1274d, 0.0926d, -0.9875d},
            {0.2517d, 0.1828d, -0.9504d},
            {0.3696d, 0.2686d, -0.8895d},
            {0.4784d, 0.3476d, -0.8065d},
            {0.5752d, 0.4179d, -0.7033d},
            {0.6576d, 0.4778d, -0.5825d},
            {-0.0487d, 0.1498d, -0.9875d},
            {-0.0961d, 0.2959d, -0.9504d},
            {-0.1412d, 0.4345d, -0.8895d},
            {-0.1827d, 0.5623d, -0.8065d},
            {-0.2197d, 0.6761d, -0.7033d},
            {-0.2512d, 0.7730d, -0.5825d},
            {-0.1575d, -0.0000d, -0.9875d},
            {-0.3111d, -0.0000d, -0.9504d},
            {-0.4569d, -0.0000d, -0.8895d},
            {-0.5913d, -0.0000d, -0.8065d},
            {-0.7109d, -0.0000d, -0.7033d},
            {-0.8128d, -0.0000d, -0.5825d},
            {-0.0487d, -0.1498d, -0.9875d},
            {-0.0961d, -0.2959d, -0.9504d},
            {-0.1412d, -0.4345d, -0.8895d},
            {-0.1827d, -0.5623d, -0.8065d},
            {-0.2197d, -0.6761d, -0.7033d},
            {-0.2512d, -0.7730d, -0.5825d},
            {0.1274d, -0.0926d, -0.9875d},
            {0.2517d, -0.1828d, -0.9504d},
            {0.3696d, -0.2686d, -0.8895d},
            {0.4784d, -0.3476d, -0.8065d},
            {0.5752d, -0.4179d, -0.7033d},
            {0.6576d, -0.4778d, -0.5825d},
            {0.2071d, 0.1505d, 0.9667d},
            {0.3624d, 0.1514d, 0.9197d},
            {0.2560d, 0.2978d, 0.9197d},
            {0.5100d, 0.1523d, 0.8466d},
            {0.4127d, 0.2999d, 0.8601d},
            {0.3025d, 0.4380d, 0.8466d},
            {0.6455d, 0.1528d, 0.7483d},
            {0.5609d, 0.3011d, 0.7712d},
            {0.4597d, 0.4404d, 0.7712d},
            {0.3448d, 0.5667d, 0.7483d},
            {0.7641d, 0.1522d, 0.6269d},
            {0.6944d, 0.3002d, 0.6540d},
            {0.6056d, 0.4400d, 0.6631d},
            {0.5001d, 0.5676d, 0.6540d},
            {0.3809d, 0.6797d, 0.6269d},
            {-0.0791d, 0.2435d, 0.9667d},
            {-0.0320d, 0.3914d, 0.9197d},
            {-0.2042d, 0.3355d, 0.9197d},
            {0.0127d, 0.5321d, 0.8466d},
            {-0.1577d, 0.4852d, 0.8601d},
            {-0.3231d, 0.4230d, 0.8466d},
            {0.0541d, 0.6611d, 0.7483d},
            {-0.1130d, 0.6265d, 0.7712d},
            {-0.2768d, 0.5732d, 0.7712d},
            {-0.4324d, 0.5030d, 0.7483d},
            {0.0914d, 0.7738d, 0.6269d},
            {-0.0709d, 0.7532d, 0.6540d},
            {-0.2313d, 0.7119d, 0.6631d},
            {-0.3853d, 0.6510d, 0.6540d},
            {-0.5287d, 0.5723d, 0.6269d},
            {-0.2560d, -0.0000d, 0.9667d},
            {-0.3822d, 0.0905d, 0.9197d},
            {-0.3822d, -0.0905d, 0.9197d},
            {-0.5022d, 0.1765d, 0.8466d},
            {-0.5102d, -0.0000d, 0.8601d},
            {-0.5022d, -0.1765d, 0.8466d},
            {-0.6120d, 0.2558d, 0.7483d},
            {-0.6307d, 0.0861d, 0.7712d},
            {-0.6307d, -0.0861d, 0.7712d},
            {-0.6120d, -0.2558d, 0.7483d},
            {-0.7077d, 0.3260d, 0.6269d},
            {-0.7383d, 0.1653d, 0.6540d},
            {-0.7485d, -0.0000d, 0.6631d},
            {-0.7383d, -0.1653d, 0.6540d},
            {-0.7077d, -0.3260d, 0.6269d},
            {-0.0791d, -0.2435d, 0.9667d},
            {-0.2042d, -0.3355d, 0.9197d},
            {-0.0320d, -0.3914d, 0.9197d},
            {-0.3231d, -0.4230d, 0.8466d},
            {-0.1576d, -0.4852d, 0.8601d},
            {0.0127d, -0.5321d, 0.8466d},
            {-0.4324d, -0.5030d, 0.7483d},
            {-0.2768d, -0.5732d, 0.7712d},
            {-0.1130d, -0.6265d, 0.7712d},
            {0.0541d, -0.6611d, 0.7483d},
            {-0.5287d, -0.5723d, 0.6269d},
            {-0.3853d, -0.6510d, 0.6540d},
            {-0.2313d, -0.7119d, 0.6631d},
            {-0.0709d, -0.7532d, 0.6540d},
            {0.0914d, -0.7738d, 0.6269d},
            {0.2071d, -0.1505d, 0.9667d},
            {0.2560d, -0.2978d, 0.9197d},
            {0.3624d, -0.1514d, 0.9197d},
            {0.3025d, -0.4380d, 0.8466d},
            {0.4127d, -0.2999d, 0.8601d},
            {0.5100d, -0.1523d, 0.8466d},
            {0.3448d, -0.5667d, 0.7483d},
            {0.4597d, -0.4404d, 0.7712d},
            {0.5609d, -0.3011d, 0.7712d},
            {0.6455d, -0.1528d, 0.7483d},
            {0.3809d, -0.6797d, 0.6269d},
            {0.5001d, -0.5676d, 0.6540d},
            {0.6056d, -0.4400d, 0.6631d},
            {0.6944d, -0.3002d, 0.6540d},
            {0.7641d, -0.1522d, 0.6269d},
            {0.9791d, 0.0000d, 0.2034d},
            {0.9935d, -0.0905d, 0.0695d},
            {0.9935d, 0.0905d, 0.0695d},
            {0.9818d, -0.1765d, -0.0705d},
            {0.9974d, 0.0000d, -0.0717d},
            {0.9818d, 0.1765d, -0.0705d},
            {0.9430d, -0.2558d, -0.2127d},
            {0.9719d, -0.0861d, -0.2192d},
            {0.9719d, 0.0861d, -0.2192d},
            {0.9430d, 0.2558d, -0.2127d},
            {0.8771d, -0.3260d, -0.3526d},
            {0.9151d, -0.1653d, -0.3679d},
            {0.9278d, 0.0000d, -0.3730d},
            {0.9151d, 0.1653d, -0.3679d},
            {0.8771d, 0.3260d, -0.3526d},
            {0.3026d, 0.9312d, 0.2034d},
            {0.3931d, 0.9169d, 0.0695d},
            {0.2209d, 0.9728d, 0.0695d},
            {0.4713d, 0.8792d, -0.0705d},
            {0.3082d, 0.9486d, -0.0717d},
            {0.1355d, 0.9883d, -0.0705d},
            {0.5347d, 0.8178d, -0.2127d},
            {0.3822d, 0.8977d, -0.2192d},
            {0.2184d, 0.9509d, -0.2192d},
            {0.0481d, 0.9759d, -0.2127d},
            {0.5811d, 0.7335d, -0.3526d},
            {0.4400d, 0.8192d, -0.3679d},
            {0.2867d, 0.8824d, -0.3730d},
            {0.1256d, 0.9214d, -0.3679d},
            {-0.0390d, 0.9350d, -0.3526d},
            {-0.7921d, 0.5755d, 0.2034d},
            {-0.7505d, 0.6572d, 0.0695d},
            {-0.8569d, 0.5107d, 0.0695d},
            {-0.6905d, 0.7199d, -0.0705d},
            {-0.8069d, 0.5863d, -0.0717d},
            {-0.8980d, 0.4342d, -0.0705d},
            {-0.6126d, 0.7612d, -0.2127d},
            {-0.7356d, 0.6409d, -0.2192d},
            {-0.8369d, 0.5016d, -0.2192d},
            {-0.9133d, 0.3474d, -0.2127d},
            {-0.5180d, 0.7793d, -0.3526d},
            {-0.6432d, 0.6716d, -0.3679d},
            {-0.7506d, 0.5454d, -0.3730d},
            {-0.8375d, 0.4042d, -0.3679d},
            {-0.9012d, 0.2518d, -0.3526d},
            {-0.7921d, -0.5755d, 0.2034d},
            {-0.8569d, -0.5107d, 0.0695d},
            {-0.7505d, -0.6572d, 0.0695d},
            {-0.8980d, -0.4342d, -0.0705d},
            {-0.8069d, -0.5863d, -0.0717d},
            {-0.6905d, -0.7199d, -0.0705d},
            {-0.9133d, -0.3474d, -0.2127d},
            {-0.8369d, -0.5016d, -0.2192d},
            {-0.7356d, -0.6409d, -0.2192d},
            {-0.6126d, -0.7612d, -0.2127d},
            {-0.9012d, -0.2518d, -0.3526d},
            {-0.8375d, -0.4042d, -0.3679d},
            {-0.7506d, -0.5454d, -0.3730d},
            {-0.6432d, -0.6716d, -0.3679d},
            {-0.5180d, -0.7793d, -0.3526d},
            {0.3026d, -0.9312d, 0.2034d},
            {0.2209d, -0.9728d, 0.0695d},
            {0.3931d, -0.9169d, 0.0695d},
            {0.1355d, -0.9883d, -0.0705d},
            {0.3082d, -0.9486d, -0.0717d},
            {0.4713d, -0.8792d, -0.0705d},
            {0.0481d, -0.9759d, -0.2127d},
            {0.2184d, -0.9509d, -0.2192d},
            {0.3822d, -0.8977d, -0.2192d},
            {0.5347d, -0.8178d, -0.2127d},
            {-0.0390d, -0.9350d, -0.3526d},
            {0.1256d, -0.9214d, -0.3679d},
            {0.2867d, -0.8824d, -0.3730d},
            {0.4400d, -0.8192d, -0.3679d},
            {0.5811d, -0.7335d, -0.3526d},
            {0.7921d, 0.5755d, -0.2034d},
            {0.7505d, 0.6572d, -0.0695d},
            {0.8569d, 0.5107d, -0.0695d},
            {0.6905d, 0.7199d, 0.0705d},
            {0.8069d, 0.5863d, 0.0717d},
            {0.8980d, 0.4342d, 0.0705d},
            {0.6126d, 0.7612d, 0.2127d},
            {0.7356d, 0.6409d, 0.2192d},
            {0.8369d, 0.5016d, 0.2192d},
            {0.9133d, 0.3474d, 0.2127d},
            {0.5180d, 0.7793d, 0.3526d},
            {0.6432d, 0.6716d, 0.3679d},
            {0.7506d, 0.5454d, 0.3730d},
            {0.8375d, 0.4042d, 0.3679d},
            {0.9012d, 0.2518d, 0.3526d},
            {-0.3026d, 0.9312d, -0.2034d},
            {-0.3931d, 0.9169d, -0.0695d},
            {-0.2209d, 0.9728d, -0.0695d},
            {-0.4713d, 0.8792d, 0.0705d},
            {-0.3082d, 0.9486d, 0.0717d},
            {-0.1355d, 0.9883d, 0.0705d},
            {-0.5347d, 0.8178d, 0.2127d},
            {-0.3822d, 0.8977d, 0.2192d},
            {-0.2184d, 0.9509d, 0.2192d},
            {-0.0481d, 0.9759d, 0.2127d},
            {-0.5811d, 0.7335d, 0.3526d},
            {-0.4400d, 0.8192d, 0.3679d},
            {-0.2867d, 0.8824d, 0.3730d},
            {-0.1256d, 0.9214d, 0.3679d},
            {0.0390d, 0.9350d, 0.3526d},
            {-0.9791d, -0.0000d, -0.2034d},
            {-0.9935d, -0.0905d, -0.0695d},
            {-0.9935d, 0.0905d, -0.0695d},
            {-0.9818d, -0.1765d, 0.0705d},
            {-0.9974d, -0.0000d, 0.0717d},
            {-0.9818d, 0.1765d, 0.0705d},
            {-0.9430d, -0.2558d, 0.2127d},
            {-0.9719d, -0.0861d, 0.2192d},
            {-0.9719d, 0.0861d, 0.2192d},
            {-0.9430d, 0.2558d, 0.2127d},
            {-0.8771d, -0.3260d, 0.3526d},
            {-0.9151d, -0.1653d, 0.3679d},
            {-0.9278d, -0.0000d, 0.3730d},
            {-0.9151d, 0.1653d, 0.3679d},
            {-0.8771d, 0.3260d, 0.3526d},
            {-0.3026d, -0.9312d, -0.2034d},
            {-0.2209d, -0.9728d, -0.0695d},
            {-0.3931d, -0.9169d, -0.0695d},
            {-0.1355d, -0.9883d, 0.0705d},
            {-0.3082d, -0.9486d, 0.0717d},
            {-0.4713d, -0.8792d, 0.0705d},
            {-0.0481d, -0.9759d, 0.2127d},
            {-0.2184d, -0.9509d, 0.2192d},
            {-0.3822d, -0.8977d, 0.2192d},
            {-0.5347d, -0.8178d, 0.2127d},
            {0.0390d, -0.9350d, 0.3526d},
            {-0.1256d, -0.9214d, 0.3679d},
            {-0.2867d, -0.8824d, 0.3730d},
            {-0.4400d, -0.8192d, 0.3679d},
            {-0.5811d, -0.7335d, 0.3526d},
            {0.7921d, -0.5755d, -0.2034d},
            {0.8569d, -0.5107d, -0.0695d},
            {0.7505d, -0.6572d, -0.0695d},
            {0.8980d, -0.4342d, 0.0705d},
            {0.8069d, -0.5863d, 0.0717d},
            {0.6905d, -0.7199d, 0.0705d},
            {0.9133d, -0.3474d, 0.2127d},
            {0.8369d, -0.5016d, 0.2192d},
            {0.7356d, -0.6409d, 0.2192d},
            {0.6126d, -0.7612d, 0.2127d},
            {0.9012d, -0.2518d, 0.3526d},
            {0.8375d, -0.4042d, 0.3679d},
            {0.7506d, -0.5454d, 0.3730d},
            {0.6432d, -0.6716d, 0.3679d},
            {0.5180d, -0.7793d, 0.3526d},
            {0.0791d, 0.2435d, -0.9667d},
            {0.0320d, 0.3914d, -0.9197d},
            {0.2042d, 0.3355d, -0.9197d},
            {-0.0127d, 0.5321d, -0.8466d},
            {0.1577d, 0.4852d, -0.8601d},
            {0.3231d, 0.4230d, -0.8466d},
            {-0.0541d, 0.6611d, -0.7483d},
            {0.1130d, 0.6265d, -0.7712d},
            {0.2768d, 0.5732d, -0.7712d},
            {0.4324d, 0.5030d, -0.7483d},
            {-0.0914d, 0.7738d, -0.6269d},
            {0.0709d, 0.7532d, -0.6540d},
            {0.2313d, 0.7119d, -0.6631d},
            {0.3853d, 0.6510d, -0.6540d},
            {0.5287d, 0.5723d, -0.6269d},
            {-0.2071d, 0.1505d, -0.9667d},
            {-0.3624d, 0.1514d, -0.9197d},
            {-0.2560d, 0.2978d, -0.9197d},
            {-0.5100d, 0.1523d, -0.8466d},
            {-0.4127d, 0.2999d, -0.8601d},
            {-0.3025d, 0.4380d, -0.8466d},
            {-0.6455d, 0.1528d, -0.7483d},
            {-0.5609d, 0.3011d, -0.7712d},
            {-0.4597d, 0.4404d, -0.7712d},
            {-0.3448d, 0.5667d, -0.7483d},
            {-0.7641d, 0.1522d, -0.6269d},
            {-0.6944d, 0.3002d, -0.6540d},
            {-0.6056d, 0.4400d, -0.6631d},
            {-0.5001d, 0.5676d, -0.6540d},
            {-0.3809d, 0.6797d, -0.6269d},
            {-0.2071d, -0.1505d, -0.9667d},
            {-0.2560d, -0.2978d, -0.9197d},
            {-0.3624d, -0.1514d, -0.9197d},
            {-0.3025d, -0.4380d, -0.8466d},
            {-0.4127d, -0.2999d, -0.8601d},
            {-0.5100d, -0.1523d, -0.8466d},
            {-0.3448d, -0.5667d, -0.7483d},
            {-0.4597d, -0.4404d, -0.7712d},
            {-0.5609d, -0.3011d, -0.7712d},
            {-0.6455d, -0.1528d, -0.7483d},
            {-0.3809d, -0.6797d, -0.6269d},
            {-0.5001d, -0.5676d, -0.6540d},
            {-0.6056d, -0.4400d, -0.6631d},
            {-0.6944d, -0.3002d, -0.6540d},
            {-0.7641d, -0.1522d, -0.6269d},
            {0.0791d, -0.2435d, -0.9667d},
            {0.2042d, -0.3355d, -0.9197d},
            {0.0320d, -0.3914d, -0.9197d},
            {0.3231d, -0.4230d, -0.8466d},
            {0.1577d, -0.4852d, -0.8601d},
            {-0.0127d, -0.5321d, -0.8466d},
            {0.4324d, -0.5030d, -0.7483d},
            {0.2768d, -0.5732d, -0.7712d},
            {0.1130d, -0.6265d, -0.7712d},
            {-0.0541d, -0.6611d, -0.7483d},
            {0.5287d, -0.5723d, -0.6269d},
            {0.3853d, -0.6510d, -0.6540d},
            {0.2313d, -0.7119d, -0.6631d},
            {0.0709d, -0.7532d, -0.6540d},
            {-0.0914d, -0.7738d, -0.6269d},
            {0.2560d, 0.0000d, -0.9667d},
            {0.3822d, 0.0905d, -0.9197d},
            {0.3822d, -0.0905d, -0.9197d},
            {0.5022d, 0.1765d, -0.8466d},
            {0.5102d, 0.0000d, -0.8601d},
            {0.5022d, -0.1765d, -0.8466d},
            {0.6120d, 0.2558d, -0.7483d},
            {0.6307d, 0.0861d, -0.7712d},
            {0.6307d, -0.0861d, -0.7712d},
            {0.6120d, -0.2558d, -0.7483d},
            {0.7077d, 0.3260d, -0.6269d},
            {0.7383d, 0.1653d, -0.6540d},
            {0.7485d, 0.0000d, -0.6631d},
            {0.7383d, -0.1653d, -0.6540d},
            {0.7077d, -0.3260d, -0.6269d}};

    public Grid() {
        angle = (float) (Math.PI / 34.);

        /*	float tempTab[162][3] ={
        {0.0000,0.0000,1.0000  },
        {0.8944,0.0000,0.4472  },
        {0.2764,0.8507,0.4472  },
        {-0.7236,0.5257,0.4472 },
        {-0.7236,-0.5257,0.4472},
        {0.2764,-0.8507,0.4472 },
        {0.7236,0.5257,-0.447  },
        {-0.2764,0.8507,-0.447 },
        {-0.8944,-0.0000,-0.447},
        {-0.2764,-0.8507,-0.447},
        {0.7236,-0.5257,-0.447 },
        {0.0000,0.0000,-1.000  },
        {0.2733,0.0000,0.9619  },
        {0.5257,0.0000,0.8507  },
        {0.7382,0.0000,0.6746  },
        {0.0844,0.2599,0.9619  },
        {0.1625,0.5000,0.8507  },
        {0.2281,0.7020,0.6746  },
        {-0.2211,0.1606,0.9619 },
        {-0.4253,0.3090,0.8507 },
        {-0.5972,0.4339,0.6746 },
        {-0.2211,-0.1606,0.9619},
        {-0.4253,-0.3090,0.8507},
        {-0.5972,-0.4339,0.6746},
        {0.0844,-0.2599,0.9619 },
        {0.1625,-0.5000,0.8507 },
        {0.2281,-0.7020,0.6746 },
        {0.8226,0.2599,0.5057  },
        {0.6882,0.5000,0.5257  },
        {0.5014,0.7020,0.5057  },
        {0.0070,0.8627,0.5057  },
        {-0.2629,0.8090,0.5257 },
        {-0.5128,0.6938,0.5057 },
        {-0.8183,0.2733,0.5057 },
        {-0.8507,-0.0000,0.5257},
        {-0.8183,-0.2733,0.5057},
        {-0.5128,-0.6938,0.5057},
        {-0.2629,-0.8090,0.5257},
        {0.0070,-0.8627,0.5057 },
        {0.5014,-0.7020,0.5057 },
        {0.6882,-0.5000,0.5257 },
        {0.8226,-0.2599,0.5057 },
        {0.9593,0.1606,0.2325  },
        {0.9511,0.3090,0.0000  },
        {0.8705,0.4339,-0.232  },
        {0.1437,0.9619,0.2325  },
        {-0.0000,1.0000,0.0000 },
        {-0.1437,0.9619,-0.232 },
        {-0.8705,0.4339,0.2325 },
        {-0.9511,0.3090,0.0000 },
        {-0.9593,0.1606,-0.232 },
        {-0.6816,-0.6938,0.2325},
        {-0.5878,-0.8090,0.0000},
        {-0.4492,-0.8627,-0.232},
        {0.4492,-0.8627,0.2325 },
        {0.5878,-0.8090,0.0000 },
        {0.6816,-0.6938,-0.232 },
        {0.9593,-0.1606,0.2325 },
        {0.9511,-0.3090,0.0000 },
        {0.8705,-0.4339,-0.232 },
        {0.4492,0.8627,0.2325  },
        {0.5878,0.8090,0.0000  },
        {0.6816,0.6938,-0.232  },
        {-0.6816,0.6938,0.2325 },
        {-0.5878,0.8090,0.0000 },
        {-0.4492,0.8627,-0.232 },
        {-0.8705,-0.4339,0.2325},
        {-0.9511,-0.3090,0.0000},
        {-0.9593,-0.1606,-0.232},
        {0.1437,-0.9619,0.2325 },
        {0.0000,-1.0000,0.0000 },
        {-0.1437,-0.9619,-0.232},
        {0.5128,0.6938,-0.505  },
        {0.2629,0.8090,-0.525  },
        {-0.0070,0.8627,-0.505 },
        {-0.5014,0.7020,-0.505 },
        {-0.6882,0.5000,-0.525 },
        {-0.8226,0.2599,-0.505 },
        {-0.8226,-0.2599,-0.505},
        {-0.6882,-0.5000,-0.525},
        {-0.5014,-0.7020,-0.505},
        {-0.0070,-0.8627,-0.505},
        {0.2629,-0.8090,-0.525 },
        {0.5128,-0.6938,-0.505 },
        {0.8183,-0.2733,-0.505 },
        {0.8507,0.0000,-0.525  },
        {0.8183,0.2733,-0.505  },
        {0.2211,0.1606,-0.961  },
        {0.4253,0.3090,-0.850  },
        {0.5972,0.4339,-0.674  },
        {-0.0844,0.2599,-0.961 },
        {-0.1625,0.5000,-0.850 },
        {-0.2281,0.7020,-0.674 },
        {-0.2733,-0.0000,-0.961},
        {-0.5257,-0.0000,-0.850},
        {-0.7382,-0.0000,-0.674},
        {-0.0844,-0.2599,-0.961},
        {-0.1625,-0.5000,-0.850},
        {-0.2281,-0.7020,-0.674},
        {0.2211,-0.1606,-0.961 },
        {0.4253,-0.3090,-0.850 },
        {0.5972,-0.4339,-0.674 },
        {0.3618,0.2629,0.8944  },
        {0.6179,0.2647,0.7404  },
        {0.4427,0.5058,0.7404  },
        {-0.1382,0.4253,0.8944 },
        {-0.0608,0.6694,0.7404 },
        {-0.3443,0.5773,0.7404 },
        {-0.4472,-0.0000,0.8944},
        {-0.6554,0.1490,0.7404 },
        {-0.6554,-0.1490,0.7404},
        {-0.1382,-0.4253,0.8944},
        {-0.3443,-0.5773,0.7404},
        {-0.0608,-0.6694,0.7404},
        {0.3618,-0.2629,0.8944 },
        {0.4427,-0.5058,0.7404 },
        {0.6179,-0.2647,0.7404 },
        {1.0000,0.0000,0.0000  },
        {0.9554,-0.1490,-0.255 },
        {0.9554,0.1490,-0.255  },
        {0.3090,0.9511,0.0000  },
        {0.4370,0.8625,-0.255  },
        {0.1535,0.9547,-0.255  },
        {-0.8090,0.5878,0.0000 },
        {-0.6853,0.6821,-0.255 },
        {-0.8605,0.4410,-0.255 },
        {-0.8090,-0.5878,0.0000},
        {-0.8605,-0.4410,-0.255},
        {-0.6853,-0.6821,-0.255},
        {0.3090,-0.9511,0.0000 },
        {0.1535,-0.9547,-0.255 },
        {0.4370,-0.8625,-0.255 },
        {0.8090,0.5878,0.0000  },
        {0.6853,0.6821,0.2551  },
        {0.8605,0.4410,0.2551  },
        {-0.3090,0.9511,0.0000 },
        {-0.4370,0.8625,0.2551 },
        {-0.1535,0.9547,0.2551 },
        {-1.0000,-0.0000,0.0000},
        {-0.9554,-0.1490,0.2551},
        {-0.9554,0.1490,0.2551 },
        {-0.3090,-0.9511,0.0000},
        {-0.1535,-0.9547,0.2551},
        {-0.4370,-0.8625,0.2551},
        {0.8090,-0.5878,0.0000 },
        {0.8605,-0.4410,0.2551 },
        {0.6853,-0.6821,0.2551 },
        {0.1382,0.4253,-0.894  },
        {0.0608,0.6694,-0.740  },
        {0.3443,0.5773,-0.740  },
        {-0.3618,0.2629,-0.894 },
        {-0.6179,0.2647,-0.740 },
        {-0.4427,0.5058,-0.740 },
        {-0.3618,-0.2629,-0.894},
        {-0.4427,-0.5058,-0.740},
        {-0.6179,-0.2647,-0.740},
        {0.1382,-0.4253,-0.894 },
        {0.3443,-0.5773,-0.740 },
        {0.0608,-0.6694,-0.740 },
        {0.4472,0.0000,-0.894  },
        {0.6554,0.1490,-0.740  },
        {0.6554,-0.1490,-0.740 }};
        */
        points = new Vector3d[tempTab.length];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Vector3d(tempTab[i]);
        }

        result = new int[tempTab.length];
    }

    public int getNearest(Tuple3d p) {
        int bestI = -1;
        double bestDot = -2.0;

        Vector3d v = new Vector3d(p);
        v.normalize();
        for (int i = 0; i < tempTab.length; ++i) {
            if (v.dot(points[i]) > bestDot) {
                bestI = i;
                bestDot = v.dot(points[i]);
            }
        }
        return bestI;
    }

    void draw() {
        for (int i = 0; i < tempTab.length; ++i) {
            Vector3d point = points[i];
            Draw.drawPoint(point.x, point.y, point.z);
        }
    }

    /**
     * @param equVision
     * @param fieldAngle
     * @return An array with the number of the zones in the field of view
     */
    public int intersect(Tuple3d equVision, double fieldAngle) {
        Vector3d pos = new Vector3d(equVision);
        pos.normalize();
        float max = (float) Math.cos(fieldAngle / 2.f + angle);

        int nbResult = 0;
        for (int i = 0; i < tempTab.length; ++i) {
            if (pos.dot(points[i]) > max) {
                result[nbResult] = i;
                ++nbResult;
            }
        }
        return nbResult;
    }

    /*
    float tempTab[92][3] ={
    {0.0000,0.0000,1.0000    },
    {0.8944,0.0000,0.4472    },
    {0.2764,0.8507,0.4472    },
    {-0.7236,0.5257,0.4472   },
    {-0.7236,-0.5257,0.4472  },
    {0.2764,-0.8507,0.4472   },
    {0.7236,0.5257,-0.4472   },
    {-0.2764,0.8507,-0.4472  },
    {-0.8944,-0.0000,-0.4472 },
    {-0.2764,-0.8507,-0.4472 },
    {0.7236,-0.5257,-0.4472  },
    {0.0000,0.0000,-1.0000   },
    {0.3607,0.0000,0.9327    },
    {0.6729,0.0000,0.7397    },
    {0.1115,0.3431,0.9327    },
    {0.2079,0.6399,0.7397    },
    {-0.2918,0.2120,0.9327   },
    {-0.5444,0.3955,0.7397   },
    {-0.2918,-0.2120,0.9327  },
    {-0.5444,-0.3955,0.7397  },
    {0.1115,-0.3431,0.9327   },
    {0.2079,-0.6399,0.7397   },
    {0.7844,0.3431,0.5168    },
    {0.5687,0.6399,0.5168    },
    {-0.0839,0.8520,0.5168   },
    {-0.4329,0.7386,0.5168   },
    {-0.8362,0.1835,0.5168   },
    {-0.8362,-0.1835,0.5168  },
    {-0.4329,-0.7386,0.5168  },
    {-0.0839,-0.8520,0.5168  },
    {0.5687,-0.6399,0.5168   },
    {0.7844,-0.3431,0.5168   },
    {0.9647,0.2120,0.1561    },
    {0.9051,0.3955,-0.1561   },
    {0.0965,0.9830,0.1561    },
    {-0.0965,0.9830,-0.1561  },
    {-0.9051,0.3955,0.1561   },
    {-0.9647,0.2120,-0.1561  },
    {-0.6558,-0.7386,0.1561  },
    {-0.4998,-0.8520,-0.1561 },
    {0.4998,-0.8520,0.1561   },
    {0.6558,-0.7386,-0.1561  },
    {0.9647,-0.2120,0.1561   },
    {0.9051,-0.3955,-0.1561  },
    {0.4998,0.8520,0.1561    },
    {0.6558,0.7386,-0.1561   },
    {-0.6558,0.7386,0.1561   },
    {-0.4998,0.8520,-0.1561  },
    {-0.9051,-0.3955,0.1561  },
    {-0.9647,-0.2120,-0.1561 },
    {0.0965,-0.9830,0.1561   },
    {-0.0965,-0.9830,-0.1561 },
    {0.4329,0.7386,-0.5168   },
    {0.0839,0.8520,-0.5168   },
    {-0.5687,0.6399,-0.5168  },
    {-0.7844,0.3431,-0.5168  },
    {-0.7844,-0.3431,-0.5168 },
    {-0.5687,-0.6399,-0.5168 },
    {0.0839,-0.8520,-0.5168  },
    {0.4329,-0.7386,-0.5168  },
    {0.8362,-0.1835,-0.5168  },
    {0.8362,0.1835,-0.5168   },
    {0.2918,0.2120,-0.9327   },
    {0.5444,0.3955,-0.7397   },
    {-0.1115,0.3431,-0.9327  },
    {-0.2079,0.6399,-0.7397  },
    {-0.3607,-0.0000,-0.9327 },
    {-0.6729,-0.0000,-0.7397 },
    {-0.1115,-0.3431,-0.9327 },
    {-0.2079,-0.6399,-0.7397 },
    {0.2918,-0.2120,-0.9327  },
    {0.5444,-0.3955,-0.7397  },
    {0.4795,0.3484,0.8054    },
    {-0.1832,0.5637,0.8054   },
    {-0.5927,-0.0000,0.8054  },
    {-0.1832,-0.5637,0.8054  },
    {0.4795,-0.3484,0.8054   },
    {0.9855,0.0000,-0.1699   },
    {0.3045,0.9372,-0.1699   },
    {-0.7973,0.5792,-0.1699  },
    {-0.7973,-0.5792,-0.1699 },
    {0.3045,-0.9372,-0.1699  },
    {0.7973,0.5792,0.1699    },
    {-0.3045,0.9372,0.1699   },
    {-0.9855,-0.0000,0.1699  },
    {-0.3045,-0.9372,0.1699  },
    {0.7973,-0.5792,0.1699   },
    {0.1832,0.5637,-0.8054   },
    {-0.4795,0.3484,-0.8054  },
    {-0.4795,-0.3484,-0.8054 },
    {0.1832,-0.5637,-0.8054  },
    {0.5927,0.0000,-0.8054   }};
    */
    /*
    float tempTab[42][3] ={
    {0.0000,0.0000,1.0000   },
    {0.8944,0.0000,0.4472   },
    {0.2764,0.8507,0.4472   },
    {-0.7236,0.5257,0.4472  },
    {-0.7236,-0.5257,0.4472 },
    {0.2764,-0.8507,0.4472  },
    {0.7236,0.5257,-0.4472  },
    {-0.2764,0.8507,-0.4472 },
    {-0.8944,-0.0000,-0.4472},
    {-0.2764,-0.8507,-0.4472},
    {0.7236,-0.5257,-0.4472 },
    {0.0000,0.0000,-1.0000  },
    {0.5257,0.0000,0.8507   },
    {0.1625,0.5000,0.8507   },
    {-0.4253,0.3090,0.8507  },
    {-0.4253,-0.3090,0.8507 },
    {0.1625,-0.5000,0.8507  },
    {0.6882,0.5000,0.5257   },
    {-0.2629,0.8090,0.5257  },
    {-0.8507,-0.0000,0.5257 },
    {-0.2629,-0.8090,0.5257 },
    {0.6882,-0.5000,0.5257  },
    {0.9511,0.3090,0.0000   },
    {-0.0000,1.0000,0.0000  },
    {-0.9511,0.3090,0.0000  },
    {-0.5878,-0.8090,0.0000 },
    {0.5878,-0.8090,0.0000  },
    {0.9511,-0.3090,0.0000  },
    {0.5878,0.8090,0.0000   },
    {-0.5878,0.8090,0.0000  },
    {-0.9511,-0.3090,0.0000 },
    {0.0000,-1.0000,0.0000  },
    {0.2629,0.8090,-0.5257  },
    {-0.6882,0.5000,-0.5257 },
    {-0.6882,-0.5000,-0.5257},
    {0.2629,-0.8090,-0.5257 },
    {0.8507,0.0000,-0.5257  },
    {0.4253,0.3090,-0.8507  },
    {-0.1625,0.5000,-0.8507 },
    {-0.5257,-0.0000,-0.8507},
    {-0.1625,-0.5000,-0.8507},
    {0.4253,-0.3090,-0.8507 }};
    */
    public int[] getResult() {
        return result;
    }

    public int getNbPoints() {
        return tempTab.length;
    }

    /**
     * Radius of each zone (in radians)
     */
    private float angle;

    /**
     * The zones positions
     */
    Vector3d points[];

    int[] result;
}