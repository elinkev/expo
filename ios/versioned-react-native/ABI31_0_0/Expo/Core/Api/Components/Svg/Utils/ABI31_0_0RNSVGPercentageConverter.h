/**
 * Copyright (c) 2015-present, Horcrux.
 * All rights reserved.
 *
 * This source code is licensed under the MIT-style license found in the
 * LICENSE file in the root directory of this source tree.
 */

#import <Foundation/Foundation.h>
#import <QuartzCore/QuartzCore.h>
#import "ABI31_0_0RNSVGLength.h"

@interface ABI31_0_0RNSVGPercentageConverter : NSObject

+ (CGFloat) percentageToFloat:(NSString *)percentage relative:(CGFloat)relative offset:(CGFloat)offset;

+ (CGFloat) stringToFloat:(NSString *)string relative:(CGFloat)relative offset:(CGFloat)offset;

+ (BOOL) isPercentage:(NSString *) string;

+ (CGFloat)lengthToFloat:(ABI31_0_0RNSVGLength *)length relative:(CGFloat)relative offset:(CGFloat)offset;

@end
