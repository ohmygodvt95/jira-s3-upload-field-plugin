package ut.net.runsystem.s3field;

import org.junit.Test;
import net.runsystem.s3field.api.MyPluginComponent;
import net.runsystem.s3field.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}