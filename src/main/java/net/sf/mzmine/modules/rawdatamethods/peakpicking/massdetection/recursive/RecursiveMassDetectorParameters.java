/*
 * Copyright 2006-2018 The MZmine 2 Development Team
 * 
 * This file is part of MZmine 2.
 * 
 * MZmine 2 is free software; you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * MZmine 2 is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with MZmine 2; if not,
 * write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301
 * USA
 */

package net.sf.mzmine.modules.rawdatamethods.peakpicking.massdetection.recursive;

import java.awt.Window;

import net.sf.mzmine.main.MZmineCore;
import net.sf.mzmine.modules.rawdatamethods.peakpicking.massdetection.MassDetectorSetupDialog;
import net.sf.mzmine.parameters.UserParameter;
import net.sf.mzmine.parameters.impl.SimpleParameterSet;
import net.sf.mzmine.parameters.parametertypes.DoubleParameter;
import net.sf.mzmine.util.ExitCode;

public class RecursiveMassDetectorParameters extends SimpleParameterSet {

  public static final DoubleParameter noiseLevel = new DoubleParameter("Noise level",
      "Intensities less than this value are interpreted as noise",
      MZmineCore.getConfiguration().getIntensityFormat());

  public static final DoubleParameter minimumMZPeakWidth = new DoubleParameter("Min m/z peak width",
      "Minimum acceptable peak width in m/z", MZmineCore.getConfiguration().getMZFormat());

  public static final DoubleParameter maximumMZPeakWidth = new DoubleParameter("Max m/z peak width",
      "Maximum acceptable peak width in m/z", MZmineCore.getConfiguration().getMZFormat());

  public RecursiveMassDetectorParameters() {
    super(new UserParameter[] {noiseLevel, minimumMZPeakWidth, maximumMZPeakWidth});
  }

  public ExitCode showSetupDialog(Window parent, boolean valueCheckRequired) {
    MassDetectorSetupDialog dialog =
        new MassDetectorSetupDialog(parent, valueCheckRequired, RecursiveMassDetector.class, this);
    dialog.setVisible(true);
    return dialog.getExitCode();
  }

}
