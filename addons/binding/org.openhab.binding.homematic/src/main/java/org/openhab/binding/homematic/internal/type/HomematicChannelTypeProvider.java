/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.homematic.internal.type;

import java.util.Locale;

import org.eclipse.smarthome.core.thing.type.ChannelGroupType;
import org.eclipse.smarthome.core.thing.type.ChannelGroupTypeUID;
import org.eclipse.smarthome.core.thing.type.ChannelType;
import org.eclipse.smarthome.core.thing.type.ChannelTypeProvider;
import org.eclipse.smarthome.core.thing.type.ChannelTypeUID;
import org.openhab.binding.homematic.type.HomematicThingTypeExcluder;

/**
 * Extends the ChannelTypeProvider to manually add a ThingType.
 *
 * @author Gerhard Riegler - Initial contribution
 */
public interface HomematicChannelTypeProvider extends ChannelTypeProvider {

    /**
     * Adds the ChannelType to this provider.
     */
    public void addChannelType(ChannelType channelType);

    /**
     * Adds the ChannelGroupType to this provider.
     */
    public void addChannelGroupType(ChannelGroupType channelGroupType);
    
    /**
     * Use this method to lookup a ChannelType which was generated by the
     * homematic binding. Other than {@link #getChannelType(ChannelTypeUID, Locale)}
     * of this provider, it will return also those {@link ChannelType}s
     * which are excluded by {@link HomematicThingTypeExcluder}
     * 
     * @param channelTypeUID
     *            e.g. <i>homematic:HM-WDS40-TH-I-2_0_RSSI_DEVICE</i>
     * @return ChannelType that was added to HomematicChannelTypeProvider, identified
     *         by its config-description-uri<br>
     *         <i>null</i> if no ChannelType with the given UID was added
     *         before
     */
    public ChannelType getInternalChannelType(ChannelTypeUID channelTypeUID);
    
    /**
     * Use this method to lookup a ChannelGroupType which was generated by the
     * homematic binding. Other than {@link #getChannelGroupType(ChannelGroupTypeUID, Locale)}
     * of this provider, it will return also those {@link ChannelGroupType}s
     * which are excluded by {@link HomematicThingTypeExcluder}
     * 
     * @param channelGroupTypeUID
     *            e.g. <i>homematic:HM-WDS40-TH-I-2_0</i>
     * @return ChannelGroupType that was added to HomematicChannelGroupTypeProvider, identified
     *         by its config-description-uri<br>
     *         <i>null</i> if no ChannelGroupType with the given UID was added
     *         before
     */
    public ChannelGroupType getInternalChannelGroupType(ChannelGroupTypeUID channelGroupTypeUID);

}